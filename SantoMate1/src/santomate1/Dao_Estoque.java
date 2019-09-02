/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package santomate1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Murilo
 */
public class Dao_Estoque implements DaoE<ErvaMate> {

    @Override
    public List<ErvaMate> PesquisaTodos() {
        List<ErvaMate> contatos = new ArrayList();
        try {
            try (Connection connection = ConectBD.getConn();
                    PreparedStatement stmt = connection.prepareStatement("select * from ErvaMate");
                    ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    ErvaMate contato = new ErvaMate();
                    contato.setId(rs.getInt("id"));
                    contato.setMarca(rs.getString("marca"));
                    contato.setTipo(rs.getString("tipo"));
                    contato.setPeso(rs.getFloat("peso"));
                    contato.setPreco(rs.getFloat("preco"));
                    contatos.add(contato);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao pesquisar por Ervas Mate!");
        }
        return contatos;
    }

    @Override
    public boolean adiciona(ErvaMate m, int n) {
        Connection con = ConectBD.getConn();
        String sql = "INSERT INTO estoque (id_erva, quant) VALUES (?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setInt(1, m.getId());
            stmt.setInt(2, n + m.getQuantEstoque());
            stmt.executeUpdate();
            ConectBD.closeConn(con, stmt);
        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public int bucaId(ErvaMate erva) throws SQLException, ClassNotFoundException {
        List<ErvaMate> contatos = new Dao_Estoque().PesquisaTodos();

        for (Object mod : contatos) {
            ErvaMate c = (ErvaMate) mod;
            if (erva.getId().equals(c.getId())) {
                return c.getId();
            }
        }
        return -1;
    }

    public boolean adicionaEstoque(ErvaMate erva, int n) throws SQLException, ClassNotFoundException {
        Connection con = ConectBD.getConn();
        String sql = "UPDATE estoque SET quant = quant + ? WHERE id_erva = ?";
        PreparedStatement stmt = null;
        try {
            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setInt(1, n);
            stmt.setInt(2, erva.getId());
            stmt.executeUpdate();
            ConectBD.closeConn(con, stmt);
        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean removeEstoque(ErvaMate erva, int n) throws SQLException, ClassNotFoundException {
        Connection con = ConectBD.getConn();
        String sql = "UPDATE estoque SET quant = quant - ? WHERE id_erva = ?";
        PreparedStatement stmt = null;
        try {
            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setInt(1, n);
            stmt.setInt(2, erva.getId());
            stmt.executeUpdate();
            ConectBD.closeConn(con, stmt);
        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}
