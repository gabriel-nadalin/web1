package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Imobiliaria;

public class ImobiliariaDAO extends GenericDAO {

    public void insert(Imobiliaria imobiliaria) {
        String sql = "INSERT INTO usuario (email, senha, nome, papel) VALUES (?, ?, ?, ?)";
        String sqlImobiliaria = "INSERT INTO imobiliaria (id_usuario, cnpj, descricao) VALUES (?, ?, ?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statementUsuario = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statementUsuario.setString(1, imobiliaria.getEmail());
            statementUsuario.setString(2, imobiliaria.getSenha());
            statementUsuario.setString(3, imobiliaria.getNome());
            statementUsuario.setString(4, "imobiliaria");
            statementUsuario.executeUpdate();

            ResultSet generatedKeys = statementUsuario.getGeneratedKeys();
            if (generatedKeys.next()) {
                long idUsuario = generatedKeys.getLong(1);

                PreparedStatement statementImobiliaria = conn.prepareStatement(sqlImobiliaria);
                statementImobiliaria.setLong(1, idUsuario);
                statementImobiliaria.setString(2, imobiliaria.getCnpj());
                statementImobiliaria.setString(3, imobiliaria.getDescricao());
                statementImobiliaria.executeUpdate();
                statementImobiliaria.close();
            } else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }

            statementUsuario.close();
            generatedKeys.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Imobiliaria> getAll() {

        List<Imobiliaria> listaImobiliarias = new ArrayList<>();

        String sql = "SELECT * from usuario u, imobiliaria i WHERE u.id = i.id_usuario";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String cnpj = resultSet.getString("cnpj");
                String nome = resultSet.getString("nome");
                String descricao = resultSet.getString("descricao");
                Imobiliaria imobiliaria = new Imobiliaria(id, email, senha, cnpj, nome, descricao);
                listaImobiliarias.add(imobiliaria);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaImobiliarias;
    }

    public void delete(Imobiliaria imobiliaria) {
        String sql = "DELETE FROM usuario where id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, imobiliaria.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Imobiliaria imobiliaria) {
        String sqlUsuario = "UPDATE usuario SET email = ?, senha = ?, nome = ? WHERE id = ?";
        String sqlImobiliaria = "UPDATE imobiliaria SET cnpj = ?, descricao = ? WHERE id_usuario = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statementUsuario = conn.prepareStatement(sqlUsuario);
            statementUsuario.setString(1, imobiliaria.getEmail());
            statementUsuario.setString(2, imobiliaria.getSenha());
            statementUsuario.setString(3, imobiliaria.getNome());
            statementUsuario.setLong(4, imobiliaria.getId());
            statementUsuario.executeUpdate();

            PreparedStatement statementImobiliaria = conn.prepareStatement(sqlImobiliaria);
            statementImobiliaria.setString(1, imobiliaria.getCnpj());
            statementImobiliaria.setString(2, imobiliaria.getDescricao());
            statementImobiliaria.setLong(3, imobiliaria.getId());
            statementImobiliaria.executeUpdate();

            statementUsuario.close();
            statementImobiliaria.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Imobiliaria get(Long id) {
        Imobiliaria imobiliaria = null;

        String sql = "SELECT * from usuario u, imobiliaria i where u.id = ? and i.id_usuario = u.id";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String cnpj = resultSet.getString("cnpj");
                String nome = resultSet.getString("nome");
                String descricao = resultSet.getString("descricao");

                imobiliaria = new Imobiliaria(id, email, senha, cnpj, nome, descricao);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return imobiliaria;
    }

    public Imobiliaria get(String cnpj) {
        Imobiliaria imobiliaria = null;

        String sql = "SELECT * from usuario u, imobiliaria i where i.cnpj = ? and i.id_usuario = u.id";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, cnpj);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String nome = resultSet.getString("nome");
                String descricao = resultSet.getString("descricao");

                imobiliaria = new Imobiliaria(id, email, senha, cnpj, nome, descricao);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return imobiliaria;
    }
}
