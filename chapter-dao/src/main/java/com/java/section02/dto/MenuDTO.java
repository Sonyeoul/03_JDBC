package com.java.section02.dto;

public class MenuDTO {

    private String menuName;
    private int price;
    private String categoryCode;
    private String status;

    public MenuDTO() {
    }

    public MenuDTO(String menuName, int price, String categoryCode, String status) {
        this.menuName = menuName;
        this.price = price;
        this.categoryCode = categoryCode;
        this.status = status;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
                "menuName='" + menuName + '\'' +
                ", price=" + price +
                ", categoryCode='" + categoryCode + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
