package com.section01.INSERT;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import static com.DTO.JDBCTemplate.getConnection;

public class App2 {
    public static void main(String[] args) {
        /*
        * 사용자가 원하는 메뉴를 등록할 수 있도록 만들어주세요
        * 등록이 완료되면 성공 실패하면 실패라고 출력
        * */
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        Properties prop = new Properties();
        String menu;
        int price=0;
        int result=0;
        Scanner sc = new Scanner(System.in);
        try {
            prop.loadFromXML(new FileInputStream("src/main/resources/menudb-query.xml"));
            pstmt = con.prepareStatement(prop.getProperty("insertMenu"));
            System.out.println("원하는 메뉴이름 : ");
            menu = sc.nextLine();
            pstmt.setString(1,menu);
            System.out.println("가격 : ");
            price = sc.nextInt();
            pstmt.setInt(2,price);
            pstmt.setInt(3,4);
            pstmt.setString(4,"Y");

            pstmt.executeUpdate();
            result = pstmt.executeUpdate();
            if(result == 1){
                System.out.println("등록성공");
            }else{
                System.out.println("등록실패");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
