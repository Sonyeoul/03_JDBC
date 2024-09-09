package section03;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

public class SqlAttack {
    private static String empId= "210";
    private static String empName= "'OR 1=1 AND EMP_ID = '210";

    public static void main(String[] args) {

        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rs = null;

        String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID = '" + empId + "'AND EMP_NAME = '"+empName+"'";
        System.out.println(query);

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            if(rs.next()) {
                System.out.println(rs.getString("EMP_NAME"));
            }else{
                System.out.println("정보없음");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {

            close(con);
            close(stmt);
            close(rs);
        }

    }
}
