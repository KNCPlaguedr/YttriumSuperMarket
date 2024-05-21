
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCconnection {
    
        
    private Connection connection;
    
    public Connection getConnection() {
        return connection;
    }
    
    public void connect() throws SQLException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/yttrium","root","24071195");
            
        }catch(ClassNotFoundException e){
            
            System.out.println(e);
            
        }
    }
    
     public void disconnect() {
        try {
            if(connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Succesfully connected");
            }
        } catch (SQLException e) {
            System.out.println("Error to disconect");
        }
    }
    
}
