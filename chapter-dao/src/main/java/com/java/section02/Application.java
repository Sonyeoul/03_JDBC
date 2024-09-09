package com.java.section02;

import com.java.section02.controller.MenuController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MenuController menu = new MenuController();

        while (true) {
            System.out.println("사용할 기능선택");
            System.out.println("1. 가장 최신 메뉴 코드 조회");
            System.out.println("2. 모든 카테고리 목록 조회");
            System.out.println("3. 메뉴등록");
            System.out.println("4. 메뉴수정");
            System.out.println("9. 프로그램 종료");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: menu.findMaxCode(); break;
                case 2: menu.findCategoryList(); break;
                case 3: menu.insert(); break;
                case 4: menu.update(); break;
                case 9: return;
                default:
                    System.out.println("잘못된 입력");
                    break;
            }


        }


    }
}
