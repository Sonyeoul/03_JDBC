package com.java.common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCTemplate {

    /*
     * singleton 관리
     * 1. jdbc 커넥션은 리소스를 많이 소모하는 객체이다
     * 2. 싱글톤 패턴을 적용하면 커넥션을 재사용 가능
     *  연결과 해제에 드는 리소스 소모를 줄일 수 있다.
     * 단점
     * -성능 및 커넥션 관리 문제
     * -트랜재션 상호 간섭문제
     * 동시성 문제
     * */
    private static Connection con;
    public static Connection getConnection() {

        Properties prop = new Properties();


        try {
            if (con == null) {
                prop.load(new FileReader("src/main/resources/connection-info.properties"));
                String url = prop.getProperty("url");
                String user = prop.getProperty("user");
                String password = prop.getProperty("password");
                con = DriverManager.getConnection(url,user,password);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }
    public static Connection getConnection2(){
        Connection con2 = null;
        Properties prop = new Properties();

        try {
            prop.load(new FileReader("src/main/resources/connection-info.properties"));
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");
            con2 = DriverManager.getConnection(url,user,password);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con2;
    }
    public static void close(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void close(Statement stmt) {
        try {
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void close(ResultSet rset) {
        try {
            rset.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
