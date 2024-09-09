package com.section03;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import static com.DTO.JDBCTemplate.getConnection;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Connection con = getConnection();
        PreparedStatement ps = null;
        int result = 0;
        Properties prop = new Properties();

        System.out.println("삭제할 음식 이름");
        String a = sc.nextLine();


        try {
            prop.loadFromXML(new FileInputStream("src/main/resources/menudb-query.xml"));
            ps = con.prepareStatement(prop.getProperty("delMenu"));
            ps.setString(1, a);
            result = ps.executeUpdate();
            if(result == 1 ) {
                System.out.println("삭제성공");
            }else {
                System.out.println("실패");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
