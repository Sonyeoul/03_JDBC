package section01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.*;

public class App3 {
    public static void main(String[] args) {
        //이름 입력받고 해당 사원 아이디 이름 조회
        Scanner sc = new Scanner(System.in);
        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;
        String output;
        try {
            stmt = con.createStatement();
            String name = sc.nextLine();
            rset = stmt.executeQuery("select EMP_ID,EMP_NAME from employee where EMP_NAME = '" + name + "'");
            while (rset.next()) {
                output = rset.getString("EMP_NAME")+rset.getString("EMP_ID");
                System.out.println(output);
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
