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

public class Under {
    public static void main(String[] args) {

        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        EmployeeDTO row = null;

        List<EmployeeDTO> employees = null;

        try {
            ps = con.prepareStatement("SELECT * FROM employee order by salary DESC LIMIT 1");
            rs= ps.executeQuery();
            employees = new ArrayList<>();
            while(rs.next()) {
                row = new EmployeeDTO();
                row.setEmpId(rs.getString("EMP_ID"));
                row.setEmpName(rs.getString("EMP_NAME"));
                row.setEmpNo(rs.getString("EMP_NO"));
                row.setEmail(rs.getString("EMAIL"));
                row.setPhone(rs.getString("PHONE"));
                row.setDeptCode(rs.getString("DEPT_CODE"));
                row.setJobCode(rs.getString("JOB_CODE"));
                row.setSalLevel(rs.getString("SAL_LEVEL"));
                row.setSalary(rs.getInt("SALARY"));
                row.setBonus(rs.getDouble("BONUS"));
                row.setManagerId(rs.getString("MANAGER_ID"));
                row.setHireDate(rs.getDate("HIRE_DATE"));
                row.setEntDate(rs.getDate("ENT_DATE"));
                row.setEntYn(rs.getString("ENT_YN"));
                employees.add(row);

            }
            System.out.println(row);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(con);
            close(ps);
            close(rs);
        }
    }
}
