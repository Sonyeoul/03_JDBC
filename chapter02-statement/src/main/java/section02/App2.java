package section02;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

public class App2 {
    public static void main(String[] args) {

        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        /*
        * preparedStatement
        *  - 완성된 쿼리문과 미완성된 쿼리문을 모두 사용할 수 있다.
        *  - 미완성 쿼리 = 워치홀더를 사용한 쿼리문
        *
        * */
        try {
            ps = con.prepareStatement("SELECT EMP_ID,EMP_NAME FROM employee where emp_id = ? ");
            ps.setString(1, "200");
            rs= ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1)+" "+rs.getString(2));
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
