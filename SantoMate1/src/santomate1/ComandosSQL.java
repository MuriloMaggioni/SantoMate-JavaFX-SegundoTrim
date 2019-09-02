package santomate1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ComandosSQL {
    private static final Connection conn = null;
        
    public static ArrayList vendedoresCarreg() throws SQLException, Exception {
        ArrayList<Vendedor> vendedores = new ArrayList();
        Connection con = conectBD.getConn();
        Statement st = con.createStatement();
        String sql = ("SELECT * FROM vendedor");
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()) { 
            String CPF = rs.getString("CPF"); 
            String nome = rs.getString("nome");
            int idade = rs.getInt("idade");
            int tell = rs.getInt("telefone");
            Float sal = rs.getFloat("salario");
          
            vendedores.add(new Vendedor(CPF, nome, idade, tell, sal));
        }
        con.close();
        return vendedores;
    }
}
