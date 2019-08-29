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
    
        public static boolean addVend(Vendedor vend) throws SQLException, Exception {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection con = conectBD.getConn();
            String sql = "INSERT INTO vendedor (CPF, nome, idade, salario, telefone) VALUES (?,?,?,?,?)";
            PreparedStatement stmt = null;
            try {
                stmt = (PreparedStatement) con.prepareStatement(sql);
                stmt.setString(1, vend.getCpf() );
                stmt.setString(2, vend.getNome());
                stmt.setDate(3, (Date) vend.getIdade());
                stmt.setFloat (4, vend.getSalario());
                stmt.setInt (5, vend.getTelef());
                stmt.executeUpdate();

            } catch (SQLException ex) {
                System.err.println("Erro " + ex);
                return false;

            } finally {
                conectBD.closeConn(con, stmt);
            }
            return true;
        }
        
        public List<Vendedor> pesquisaTodos() {
        List<Vendedor> vendedores = new ArrayList();
        try {
            try (Connection connection = conectBD.getConn();
                    PreparedStatement stmt = connection.prepareStatement("Select * From Vendedores");
                    ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Vendedor contato = new Vendedor();
                    contato.setCpf(rs.getString("CPF"));
                    contato.setNome(rs.getString("nome"));
                    contato.setIdade(rs.getDate("Idade"));
                    contato.setSalario(rs.getFloat("Salario"));
                    contato.setTelef(rs.getInt("Telefone"));
                    vendedores.add(contato);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao pesquisar por contatos no banco de dados!");
        }
        return vendedores;
    }  
        
    public boolean remove(Vendedor contato) {
        try {
            try (Connection connection = conectBD.getConn();
                    PreparedStatement stmt = connection.prepareStatement("delete from Vendedor where CPF=?")) {
                stmt.setInt(1, Integer.parseInt(contato.getCpf()));
                stmt.execute();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao remover vendedor " + contato.getNome());
            return false;
        }
        return true;
    }    
        
    public static ArrayList vendedoresCarreg() throws SQLException, Exception {
        ArrayList<Vendedor> vendedores = new ArrayList();
        Connection con = conectBD.getConn();
        Statement st = con.createStatement();
        String sql = ("SELECT * FROM vendedor");
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()) { 
            String CPF = rs.getString("CPF"); 
            String nome = rs.getString("nome");
            Date idade = rs.getDate("idade");
            int tell = rs.getInt("telefone");
            Float sal = rs.getFloat("salario");
          
            vendedores.add(new Vendedor(CPF, nome, idade, tell, sal));
        }
        con.close();
        return vendedores;
    }
    
    public static int buscaCPFVend(Vendedor modelo) throws SQLException, ClassNotFoundException {
        List<Vendedor> vendedores = new ComandosSQL().pesquisaTodos();

        for (Object mod : vendedores) {
            Vendedor c = (Vendedor) mod;
            if (modelo.getNome().equals(c.getNome())) {
                return Integer.parseInt(c.getCpf());
            }
        }
        return -1;
    }
    
    public boolean pesquisa(Vendedor vend) {
        List<Vendedor> todos = pesquisaTodos();

        for (Vendedor cc : todos) {
            if (((Vendedor) cc).equals(vend)) {
                return true;
            }
        }
        return false;
    }
}
