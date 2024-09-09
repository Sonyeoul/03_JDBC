package section01.connection01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App2 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/employee";
        String user = "gangnam";
        String password = "gangnam";

        Connection con = null;
        try {
            con = DriverManager.getConnection(url,user,password);
            System.out.println(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
