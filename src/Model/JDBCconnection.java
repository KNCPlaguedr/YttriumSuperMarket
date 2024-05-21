
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCconnection {
    
        
    private Connection conexao;
    
    public Connection getConexao() {
        return conexao;
    }
    
    public void conectar() throws SQLException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/yttrium","root","24071195");
            
        }catch(ClassNotFoundException e){
            
            System.out.println(e);
            
        }
    }
    
     public void desconectar() {
        try {
            if(conexao != null && !conexao.isClosed()) {
                conexao.close();
                System.out.println("Succesfully connected");
            }
        } catch (SQLException e) {
            System.out.println("Error to disconect");
        }
    }
    
}
