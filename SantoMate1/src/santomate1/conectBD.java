//https://youtu.be/gSsGcmHl9V4
//Usei esta video aula para fazer!

package santomate1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class conectBD {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL =  "jdbc:mysql://localhost:3306/santomate";
    private static final String USER = "root";
    private static final String PASS = "";
    
    public static Connection getConn (){
        try {
            Class.forName(DRIVER);
            
            return DriverManager.getConnection(URL, USER, PASS);
                    
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro ao CONECTAR Com o Banco", ex);
        }
    }
    
    public static void closeConn(Connection conn){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException ex) {
                System.err.println("Erro ao FECHAR CONN Com o Banco"+ ex);
            }
        }
    }
    
    public static void closeConn(Connection conn, PreparedStatement stmt){
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException ex) {
                System.err.println("Erro ao FECHAR STMT Com o Banco"+ ex);

            }
        }
        closeConn(conn);
    }
    
    public static void closeConn(Connection conn, PreparedStatement stmt, ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException ex) {
                System.err.println("Erro ao FECHAR RS Com o Banco"+ ex);
            }
        }
        closeConn(conn, stmt);
    }
    
    
    
}
