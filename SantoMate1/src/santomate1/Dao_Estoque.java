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
            try (Connection connection = conectBD.getConn();
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
}
