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
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dao_Vendedor implements DaoV<Vendedor> {

    @Override
    public boolean adiciona(Vendedor vend) {
        Connection con = ConectBD.getConn();
        String sql = "INSERT INTO vendedor (CPF, nome, idade, salario, telefone) VALUES (?,?,?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, vend.getCpf());
            stmt.setString(2, vend.getNome());
            stmt.setInt(3, vend.getIdade());
            stmt.setFloat(4, vend.getSalario());
            stmt.setInt(5, vend.getTelef());
            stmt.executeUpdate();
            ConectBD.closeConn(con, stmt);
        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean remove(Vendedor contato) {
        try {
            try (Connection connection = ConectBD.getConn();
                    PreparedStatement stmt = connection.prepareStatement("delete from Vendedor where CPF=?")) {
                stmt.setString(1, (contato.getCpf()));
                stmt.execute();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao remover vendedor " + contato.getNome());
            return false;
        }
        return true;
    }

    @Override
    public boolean pesquisa(Vendedor contato) {
        List<Vendedor> todos = pesquisaTodos();

        for (Vendedor cc : todos) {
            if (((Vendedor) cc).equals(contato)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Vendedor> pesquisaTodos() {
        List<Vendedor> contatos = new ArrayList();
        try {
            try (Connection connection = ConectBD.getConn();
                    PreparedStatement stmt = connection.prepareStatement("select * from vendedor");
                    ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Vendedor contato = new Vendedor();
                    contato.setCpf(rs.getString("CPF"));
                    contato.setNome(rs.getString("nome"));
                    contato.setIdade(rs.getInt("idade"));
                    contato.setSalario(rs.getFloat("salario"));
                    contato.setTelef(rs.getInt("telefone"));
                    contatos.add(contato);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao pesquisar por contatos no banco de dados!");
        }
        return contatos;
    }

    public Vendedor pesquisaVend(String nome) {
        List<Vendedor> contatos = new Dao_Vendedor().pesquisaTodos();

        for (Object mod : contatos) {
            Vendedor c = (Vendedor) mod;
            if (c.getNome().equals(nome)) {
                return c;
            }
        }
        return null;
    }

    public String bucaCPFVend(Vendedor vend) throws SQLException, ClassNotFoundException {
        List<Vendedor> contatos = new Dao_Vendedor().pesquisaTodos();

        for (Object mod : contatos) {
            Vendedor c = (Vendedor) mod;
            if (vend.getNome().equals(c.getNome())) {
                return c.getCpf();
            }
        }
        return "";
    }
}
