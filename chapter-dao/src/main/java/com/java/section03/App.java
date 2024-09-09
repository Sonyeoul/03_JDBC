package com.java.section03;

import java.sql.Connection;
import java.sql.SQLException;

import static com.java.common.JDBCTemplate.getConnection;

public class App {
    public static void main(String[] args) {

        Connection con = getConnection();

        try {
            con.setAutoCommit(false);

            System.out.println("autocommit : " + con.getAutoCommit());
            con.commit();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
