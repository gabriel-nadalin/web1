package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Imobiliaria;
import br.ufscar.dc.dsw.domain.Imovel;

public class ImovelDAO extends GenericDAO {

    public void insert(Imovel imovel) {
        String sql = "INSERT INTO imovel (cnpj_imobiliaria, endereco, cidade, descricao, valor) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, imovel.getImobiliaria().getCnpj());
            statement.setString(2, imovel.getEndereco());
            statement.setString(3, imovel.getCidade());
            statement.setString(4, imovel.getDescricao());
            statement.setFloat(5, imovel.getValor());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Imovel> getAll() {

        List<Imovel> listaImoveis = new ArrayList<>();

        String sql = "SELECT * from imovel imv, imobiliaria imb, usuario u where imv.cnpj_imobiliaria = imb.cnpj and imb.id_usuario = u.id order by imv.id";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String cnpj_imobiliaria = resultSet.getString("cnpj_imobiliaria");
                String endereco = resultSet.getString("endereco");
                String cidade = resultSet.getString("cidade");
                String descricao = resultSet.getString("descricao");
                float valor = resultSet.getFloat("valor");
                
                Imobiliaria imobiliaria = new ImobiliariaDAO().get(cnpj_imobiliaria);

                Imovel imovel = new Imovel(id, imobiliaria, endereco, cidade, descricao, valor);
                listaImoveis.add(imovel);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaImoveis;
    }

    public void delete(Imovel imovel) {
        String sql = "DELETE FROM imovel where id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, imovel.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Imovel imovel) {
        String sql = "UPDATE imovel SET cnpj_imobiliaria = ?, endereco = ?, cidade = ?, descricao = ?, valor = ? WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, imovel.getImobiliaria().getCnpj());
            statement.setString(2, imovel.getEndereco());
            statement.setString(3, imovel.getCidade());
            statement.setString(4, imovel.getDescricao());
            statement.setFloat(5, imovel.getValor());
            statement.setLong(6, imovel.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Imovel get(Long id) {
        Imovel imovel = null;

        String sql = "SELECT * from imovel imv, imobiliaria imb where imv.id = ? and imv.cnpj_imobiliaria = imb.cnpj";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String endereco = resultSet.getString("endereco");
                String cidade = resultSet.getString("cidade");
                String descricao = resultSet.getString("descricao");
                float valor = resultSet.getFloat("valor");

                String cnpj_imobiliaria = resultSet.getString("cnpj_imobiliaria");
                Imobiliaria imobiliaria = new ImobiliariaDAO().get(cnpj_imobiliaria);

                imovel = new Imovel(id, imobiliaria, endereco, cidade, descricao, valor);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return imovel;
    }
}
