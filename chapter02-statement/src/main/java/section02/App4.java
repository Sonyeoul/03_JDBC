package section02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import static common.JDBCTemplate.getConnection;

public class App4 {
    public static void main(String[] args) {

        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);

        System.out.println("성씨 입력: ");
        String name = sc.nextLine();


    }
}
