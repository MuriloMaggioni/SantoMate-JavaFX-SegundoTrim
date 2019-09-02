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
public class Dao_Comprador implements DaoC<Comprador> {

    @Override
    public boolean adiciona(Comprador m) {
        Connection con = ConectBD.getConn();
        String sql = "INSERT INTO comprador (CPF, nome, telefone) VALUES (?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, m.getCpf());
            stmt.setString(2, m.getNome());
            stmt.setInt(3, m.getTelefone());

            stmt.executeUpdate();
            ConectBD.closeConn(con, stmt);
        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public String bucaCPFComprador(Comprador vend) throws SQLException, ClassNotFoundException {
        List<Comprador> contatos = new Dao_Comprador().pesquisaTodos();

        for (Object mod : contatos) {
            Comprador c = (Comprador) mod;
            if (vend.getNome().equals(c.getNome())) {
                return c.getCpf();
            }
        }
        return "";
    }

    @Override
    public List<Comprador> pesquisaTodos() {
        List<Comprador> contatos = new ArrayList();
        try {
            try (Connection connection = ConectBD.getConn();
                    PreparedStatement stmt = connection.prepareStatement("select * from vendedor");
                    ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Comprador contato = new Comprador();
                    contato.setCpf(rs.getString("CPF"));
                    contato.setNome(rs.getString("nome"));
                    contato.setTelefone(rs.getInt("telefone"));
                    contatos.add(contato);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao pesquisar por contatos no banco de dados!");
        }
        return contatos;
    }
}
