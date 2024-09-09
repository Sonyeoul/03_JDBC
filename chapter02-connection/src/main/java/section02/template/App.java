package section02.template;

import java.sql.Connection;

import static section02.template.JDBCTemplate.close;
import static section02.template.JDBCTemplate.getConnection;

public class App {
    public static void main(String[] args) {

        Connection con = getConnection();
        System.out.println(con);
        close(con);

    }
}
