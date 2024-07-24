package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Cliente;

public class ClienteDAO extends GenericDAO {

    public void insert(Cliente cliente) {

        String sqlUsuario = "INSERT INTO usuario (email, senha, nome, papel) VALUES (?, ?, ?, ?)";
        String sqlCliente = "INSERT INTO cliente (id_usuario, cpf, telefone, sexo, data_nascimento) VALUES (?, ?, ?, ?, ?)";
    
        try {
            Connection conn = this.getConnection();
            
            PreparedStatement statementUsuario = conn.prepareStatement(sqlUsuario, Statement.RETURN_GENERATED_KEYS);
            statementUsuario.setString(1, cliente.getEmail());
            statementUsuario.setString(2, cliente.getSenha());
            statementUsuario.setString(3, cliente.getNome());
            statementUsuario.setString(4, "CLIENT");
            statementUsuario.executeUpdate();

            ResultSet generatedKeys = statementUsuario.getGeneratedKeys();
            if (generatedKeys.next()) {
                long idUsuario = generatedKeys.getLong(1);

                PreparedStatement statementCliente = conn.prepareStatement(sqlCliente);
                statementCliente.setLong(1, idUsuario);
                statementCliente.setString(2, cliente.getCpf());
                statementCliente.setString(3, cliente.getTelefone());
                statementCliente.setString(4, cliente.getSexo());
                statementCliente.setString(5, cliente.getDataNascimento());
                statementCliente.executeUpdate();
                statementCliente.close();
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

    public List<Cliente> getAll() {

        List<Cliente> listaClientes = new ArrayList<>();

        String sql = "SELECT * from usuario u, cliente c WHERE u.id = c.id_usuario";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String cpf = resultSet.getString("cpf");
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                String sexo = resultSet.getString("sexo");
                String data_nascimento = resultSet.getString("data_nascimento");
                Cliente cliente = new Cliente(id, email, senha, cpf, nome, telefone, sexo, data_nascimento);
                listaClientes.add(cliente);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaClientes;
    }

    public void delete(Cliente cliente) {
        String sql = "DELETE FROM usuario where id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, cliente.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Cliente cliente) {
        String sqlUsuario = "UPDATE usuario SET email = ?, senha = ?, nome = ? WHERE id = ?";
        String sqlCliente = "UPDATE cliente SET cpf = ?, telefone = ?, sexo = ?, data_nascimento = ? WHERE id_usuario = ?";
    
        try {
            Connection conn = this.getConnection();
            PreparedStatement statementUsuario = conn.prepareStatement(sqlUsuario);
            statementUsuario.setString(1, cliente.getEmail());
            statementUsuario.setString(2, cliente.getSenha());
            statementUsuario.setString(3, cliente.getNome());
            statementUsuario.setLong(4, cliente.getId());
            statementUsuario.executeUpdate();

            // Update cliente table
            PreparedStatement statementCliente = conn.prepareStatement(sqlCliente);
            statementCliente.setString(1, cliente.getCpf());
            statementCliente.setString(2, cliente.getTelefone());
            statementCliente.setString(3, cliente.getSexo());
            statementCliente.setString(4, cliente.getDataNascimento());
            statementCliente.setLong(5, cliente.getId());
            statementCliente.executeUpdate();

            statementUsuario.close();
            statementCliente.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Cliente get(Long id) {
        Cliente cliente = null;

        String sql = "SELECT * from usuario u, cliente c where u.id = ? and c.id_usuario = u.id";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String cpf = resultSet.getString("cpf");
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                String sexo = resultSet.getString("sexo");
                String data_nascimento = resultSet.getString("data_nascimento");

                cliente = new Cliente(id, email, senha, cpf, nome, telefone, sexo, data_nascimento);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cliente;
    }
}
