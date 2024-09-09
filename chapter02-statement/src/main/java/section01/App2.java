package section01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static common.JDBCTemplate.*;

public class App2 {
    public static void main(String[] args) {
        //사원번호에 해당하는 사원의 정보를 조회
        //1.connection
        //2.statement 쿼리 만들기
        //3. 쿼리를 날린다
        //4. resultset으로 결과를 받는다
        Scanner sc = new Scanner(System.in);
        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset= null ;
        try {
            stmt = con.createStatement();
            String empId = sc.nextLine();
            rset = stmt.executeQuery("SELECT EMP_ID,EMP_NAME FROM EMPLOYEE WHERE EMP_NAME = "+empId);
            while (rset.next()) {
                System.out.println(rset.getString("EMP_ID")+" "+rset.getString("EMP_NAME"));
            }
            System.out.println(rset);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(con);
            close(stmt);
            close(rset);
        }

    }
}
