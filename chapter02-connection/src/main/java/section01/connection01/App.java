package section01.connection01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {

        //DB 접속을 위한 connection instance
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //DriverManager 를 이용해 connection 생성 주소 , 아이디, 비밀번호 생성
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","gangnam","gangnam");
            System.out.println(con);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
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
