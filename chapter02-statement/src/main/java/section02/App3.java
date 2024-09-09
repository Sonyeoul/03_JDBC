package section02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

public class App3 {
    public static void main(String[] args) {
        //성씨를 입력받아 해당 성을가진 사원 조회
        //EMP_NAME FRIN EMPLOYEE WHERE EMP_NAME LIKE CONCAT(?,'%')
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);


        try {
            ps = con.prepareStatement("SELECT EMP_NAME FROM EMPLOYEE WHERE EMP_NAME LIKE CONCAT(?,'%')");
            System.out.println("성씨 입력: ");
            String fir = sc.nextLine();
            ps.setString(1, fir);
            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("EMP_NAME"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(con);
            close(ps);
            close(rs);
        }
    }
}
