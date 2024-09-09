package section01;

import EmpoyeeDTO.EmployeeDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static common.JDBCTemplate.*;

public class App4 {
    public static void main(String[] args) {

        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;
        Scanner sc = new Scanner(System.in);
        EmployeeDTO selectEnp = null;
        System.out.println("조회하실 사번을 입력해주세요");
        String empId = sc.nextLine();
        String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID = "+empId;

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);
            if(rset.next()) {
                selectEnp = new EmployeeDTO();
                selectEnp.setEmpId(rset.getString("EMP_ID"));
                selectEnp.setEmpName(rset.getString("EMP_NAME"));
                selectEnp.setEmpNo(rset.getString("EMP_NO"));
                selectEnp.setEmail(rset.getString("EMAIL"));
                selectEnp.setPhone(rset.getString("PHONE"));
                selectEnp.setDeptCode(rset.getString("DEPT_CODE"));
                selectEnp.setJobCode(rset.getString("JOB_CODE"));
                selectEnp.setSalLevel(rset.getString("SAL_LEVEL"));
                selectEnp.setSalary(rset.getInt("SALARY"));
                selectEnp.setBonus(rset.getDouble("BONUS"));
                selectEnp.setManagerId(rset.getString("MANAGER_ID"));
                selectEnp.setHireDate(rset.getDate("HIRE_DATE"));
                selectEnp.setEntDate(rset.getDate("ENT_DATE"));
                selectEnp.setEntYn(rset.getString("ENT_YN"));
                System.out.println();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(con);
            close(stmt);
            close(rset);
        }
        System.out.println(selectEnp);
    }
}
