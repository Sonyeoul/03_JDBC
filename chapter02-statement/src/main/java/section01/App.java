package section01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

public class App {
    public static void main(String[] args) {

        Connection con = getConnection();
        Statement stmt = null;
        //쿼리문을 저장하고 실행하는 기능을 가진 객체
        ResultSet rset = null;
        //결과 집합을 받아 오는 용도의 객체

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery("SELECT EMP_ID,EMP_NAME FROM EMPLOYEE");

            while (rset.next()) {
                System.out.println(rset.getString("EMP_ID") + " " + rset.getString("EMP_NAME"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(con);
            close(stmt);
            close(rset);
        }

    }
}
