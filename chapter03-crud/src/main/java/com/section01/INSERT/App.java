package com.section01.INSERT;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static com.DTO.JDBCTemplate.close;
import static com.DTO.JDBCTemplate.getConnection;

public class App {
    public static void main(String[] args) {

        Connection con = getConnection();
        PreparedStatement pstmt = null;

        int result = 0;

        Properties prop = new Properties();
        try {
            prop.loadFromXML(new FileInputStream("src/main/resources/menudb-query.xml"));
            pstmt = con.prepareStatement(prop.getProperty("insertMenu"));
            pstmt.setString(1,"쌀국수");
            pstmt.setInt(2,11900);
            pstmt.setInt(3,4);
            pstmt.setString(4,"Y");

            result = pstmt.executeUpdate();
            System.out.println("결과 : "+result);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(con);
            close(pstmt);
        }
    }
}
