package com.szalma.peter.order.entity;

public enum Type {
    TSHIRT(1000), POLOSHIRT(1200), CANVASBAG(3000), SWEATPANTS(3000), SWEATER(2000), OTHER(0);
    Type(int price) {
        this.price = price;
    }

    private int price;

    public int getPrice() {return price;}
}
