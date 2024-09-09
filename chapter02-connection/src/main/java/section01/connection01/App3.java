package section01.connection01;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class App3 {
    public static void main(String[] args) {
        Properties prop = new Properties();
        //properties에 있는 파일에 있는 정보를가져올 객체
        Connection con = null;

        try {
            prop.load(new FileReader("src/main/java/config/connection-info.properties"));

            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");

            con = DriverManager.getConnection(url, user, password);
            System.out.println(con);
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
