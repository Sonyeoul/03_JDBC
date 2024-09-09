package section01;

import EmpoyeeDTO.EmployeeDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static common.JDBCTemplate.*;

public class App5 {
    public static void main(String[] args) {

        Connection con =getConnection();
        Statement stmt = null;
        ResultSet rset = null;
        EmployeeDTO row = null;

        //dto 를 묶을 리스트
        List<EmployeeDTO> employees = null;
        String query = "select * from employee";

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);
            employees = new ArrayList<>();
            while(rset.next()) {
                row = new EmployeeDTO();
                row.setEmpId(rset.getString("EMP_ID"));
                row.setEmpName(rset.getString("EMP_NAME"));
                row.setEmpNo(rset.getString("EMP_NO"));
                row.setEmail(rset.getString("EMAIL"));
                row.setPhone(rset.getString("PHONE"));
                row.setDeptCode(rset.getString("DEPT_CODE"));
                row.setJobCode(rset.getString("JOB_CODE"));
                row.setSalLevel(rset.getString("SAL_LEVEL"));
                row.setSalary(rset.getInt("SALARY"));
                row.setBonus(rset.getDouble("BONUS"));
                row.setManagerId(rset.getString("MANAGER_ID"));
                row.setHireDate(rset.getDate("HIRE_DATE"));
                row.setEntDate(rset.getDate("ENT_DATE"));
                row.setEntYn(rset.getString("ENT_YN"));
                employees.add(row);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(con);
            close(stmt);
            close(rset);
        }
        for(EmployeeDTO employee : employees) {
            System.out.println(employee);
        }

    }
}
