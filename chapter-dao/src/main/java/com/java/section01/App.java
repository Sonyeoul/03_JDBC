package com.java.section01;

import com.java.section02.dto.MenuDTO;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static com.java.common.JDBCTemplate.close;
import static com.java.common.JDBCTemplate.getConnection;

public class App {
    public static void main(String[] args) {

        Connection con = getConnection();
        Properties prop = new Properties();


        PreparedStatement pstmt1= null;
        PreparedStatement pstmt2= null;
        PreparedStatement pstmt3= null;
        ResultSet rset = null;
        ResultSet rset2= null;
        ResultSet rset3= null;
        List<Map<Integer,String>> list = null;
        int result = 0;
        int result1=0;

        try {
            prop.loadFromXML(new FileInputStream("src/main/resources/menudb-query.xml"));
            String query = prop.getProperty("selectLastMenuCode");
            String query2 = prop.getProperty("selectAllcategoryList");
            String query3 = prop.getProperty("insertMenu");


            pstmt1 = con.prepareStatement(query);
            pstmt2 = con.prepareStatement(query2);
            rset = pstmt1.executeQuery();


            if(rset.next()) {
                result = rset.getInt("MAX(MENU_CODE)");
            }
            System.out.println("최신 메뉴 코드"+result);
            rset2 = pstmt2.executeQuery();
            list = new ArrayList<>();
            while(rset2.next()) {
                Map<Integer,String> map = new HashMap<>();
                map.put(rset2.getInt("CATEGORY_CODE"), rset2.getString("CATEGORY_NAME"));
                list.add(map);
            }
            System.out.println("category list"+list);

            pstmt3 = con.prepareStatement(query3);
            pstmt3.setString(1,"학");
            pstmt3.setInt(2,12222);
            pstmt3.setInt(3,3);
            pstmt3.setString(4,"Y");
            result1 = pstmt3.executeUpdate();
            if(result1==1){
                System.out.println("성공");
            }else {
                System.out.println("실패");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {

            close(con);
            close(rset);
            close(pstmt1);
            close(con);
            close(rset2);
            close(pstmt2);
            close(con);
            close(pstmt3);

        }


    }

}
