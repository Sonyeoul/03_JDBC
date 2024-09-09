package com.java.section02.controller;
import com.java.section02.dao.MenuDAO;
import com.java.section02.dto.MenuDTO;

import java.util.List;
import java.util.Scanner;

import static com.java.common.JDBCTemplate.getConnection2;

public class MenuController {

    private MenuDAO menuDAO = new MenuDAO("src/main/resources/menudb-query.xml");

    public void findMaxCode(){
        int result = menuDAO.selectLastMenuCode(getConnection2());
        System.out.println("최신 메뉴 코드 : "+result);
    }

    public void findCategoryList(){
        List list = menuDAO.selectAllcategoryList(getConnection2());
        System.out.println(list);
    }
//    public void insertMenu1(){
//        int result = menuDAO.insertMenu(getConnection2());
//        if(result == 1){
//            System.out.println("메뉴 등록");
//        }else {
//            System.out.println("등록 실패");
//        }
//    }

    public void insert(){
        Scanner sc = new Scanner(System.in);
        MenuDTO menuDTO = new MenuDTO();
        System.out.println("메뉴 이름 입력 : ");
        menuDTO.setMenuName(sc.nextLine());
        System.out.println("메뉴 가격 입력 : ");
        menuDTO.setPrice(sc.nextInt());
        sc.nextLine();
        System.out.println("메뉴 카테고리 코드 : ");
        menuDTO.setCategoryCode(sc.nextLine());
        System.out.println("판매여부 Y/N");
        menuDTO.setStatus(sc.nextLine());

        //컨트롤러에서 입력받아 -> DTO 로 보내고 -> DAO 에서 DTO 값을 받아 데이터베이스에 등록후 getConnection을 통해 값을 불러온다
        int result = menuDAO.insert(getConnection2(), menuDTO);
        if(result == 1){
            System.out.println("메뉴 등록");
        }else {
            System.out.println("등록 실패");
        }
    }
    public void update(){
        Scanner sc = new Scanner(System.in);
        MenuDTO menuDTO = new MenuDTO();
        System.out.println("수정할 메뉴 이름 입력 : ");
        String name = sc.nextLine();
        menuDTO.setMenuName(name);
        System.out.println("업데이트할 메뉴 이름 : ");
        menuDTO.setMenuName(sc.nextLine());
        
        int result = menuDAO.update1(getConnection2(), menuDTO);
        if(result == 1){
            System.out.println("메뉴 수정 완료");
        }else{
            System.out.println("수정 실패");
        }
    }
}
