package understand;

import EmpoyeeDTO.EmployeeDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

public class Under2 {
    public static void main(String[] args) {

        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(
                    "SELECT EMP_ID, EMP_NAME, EMAIL,PHONE, b.JOB_NAME FROM employee a JOIN JOB b on a.JOB_CODE = b.JOB_CODE  WHERE a.EMP_NAME= '선동일'");
            rs= ps.executeQuery();
            while(rs.next()) {
                System.out.println(rs.getString("EMP_ID") + " " + rs.getString("EMP_NAME") + " "
                + rs.getString("EMAIL") + " " + rs.getString("PHONE")+ " " + rs.getString("JOB_NAME"));
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
