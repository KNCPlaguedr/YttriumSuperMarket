
package Model;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class WorkersDAO {

    public static boolean login(Workers w) throws SQLException {
        try {

            JDBCconnection connection = new JDBCconnection();
            connection.connect();

            String sql = "SELECT * FROM workers where user=? AND password=?";
            PreparedStatement query = connection.getConnection().prepareStatement(sql);
            query.setString(1, w.getUser());
            query.setString(2, w.getPassword());

            ResultSet rs = query.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Welcome to Yttrium, expect the unexpected!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Try Again");
                return false;
            }

        } catch (SQLException se) {
            System.out.println(se);
            return false;
        }

    }

}
