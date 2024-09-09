package com.java.section02.dao;

import com.java.section02.dto.MenuDTO;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.util.List;

import static com.java.common.JDBCTemplate.close;

public class MenuDAO {
    //데이터 엑세스 오브젝트 - 데이터베이스와 상호작용을 할 클래스 / 쿼리문 가져오기

    private Properties prop = new Properties();

    public MenuDAO(String url) {
        try {
            prop.loadFromXML(new FileInputStream(url));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int selectLastMenuCode(Connection con) {
        Statement stmt = null;
        ResultSet rset = null;
        int maxCode = 0;
        String query = prop.getProperty("selectLastMenuCode");

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);
            if (rset.next()) {
                maxCode = rset.getInt("MAX(MENU_CODE)");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(con);
            close(stmt);
            close(rset);
        }
        return maxCode;
    }


    public List<Map<Integer, String>> selectAllcategoryList(Connection con) {
        Statement stmt = null;
        ResultSet rset = null;
        String query = prop.getProperty("selectAllcategoryList");
        List<Map<Integer,String>> list = null;
        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);
            list = new ArrayList<>();
            while(rset.next()) {
                Map<Integer,String> map = new HashMap<>();
                map.put(rset.getInt("CATEGORY_CODE"), rset.getString("CATEGORY_NAME"));
                list.add(map);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(con);
            close(stmt);
            close(rset);
        }
        return list;
    }
//    public int insertMenu(Connection con, MenuDTO menuDTO) {
//        MenuDTO dto = null;
//        List<MenuDTO>  dtoList = null;
//        Scanner sc = new Scanner(System.in);
//        PreparedStatement stmt = null;
//        ResultSet rset = null;
//        int result = 0;
//        String query = prop.getProperty("insertMenu");
//        try {
//
//            dtoList = new ArrayList<>();
//            dto = new MenuDTO();
//
//            stmt = con.prepareStatement(query);
//            System.out.println("메뉴 이름 입력 : ");
//            String name = sc.nextLine();
//            System.out.println("메뉴 가격 입력 : ");
//            int price = sc.nextInt();
//            sc.nextLine();
//            System.out.println("카테고리 코드 입력 : ");
//            String category = sc.nextLine();
//            System.out.println("판매여부 Y/N");
//            String orderable = sc.nextLine();
//            dto.setMenuName(name);
//            dto.setPrice(price);
//            dto.setCategoryCode(category);
//            dto.setStatus(orderable);
//            dtoList.add(dto);
//            result = stmt.executeUpdate(query);
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }finally {
//            close(con);
//            close(stmt);
//        }return result;
//    }

    public int insert(Connection con, MenuDTO menuDTO) {
    PreparedStatement stmt = null;
    int result = 0;
    String query = prop.getProperty("insertMenu");

        try {
            stmt = con.prepareStatement(query);
            stmt.setString(1, menuDTO.getMenuName());
            stmt.setInt(2, menuDTO.getPrice());
            stmt.setString(3, menuDTO.getCategoryCode());
            stmt.setString(4, menuDTO.getStatus());

            result = stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(con);
            close(stmt);
        }
        return result;
    }
    public int update1(Connection con,MenuDTO menuDTO) {

        PreparedStatement stmt = null;
        int result = 0;
        String query = prop.getProperty("updateMenu");

        try {
            stmt = con.prepareStatement(query);
            stmt.setString(1, menuDTO.getMenuName());
            stmt.setString(2, menuDTO.getMenuName());

            result = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(con);
            close(stmt);

        }
return result;
    }

}
