package com.geekbang.RunSuperMarket.interfaces;

import java.net.CookieHandler;

public enum Category {
    FOOD(10, 300),
    Cook(200, 2000),
    SNACK(5, 100),
    CLOTHES(200, 1000),
    ELECTRIC(300, 10000);


    int lowerPrice;
    int higherPrice;

    Category(int lowerPrice, int higherPrice) {
        this.lowerPrice = lowerPrice;
        this.higherPrice = higherPrice;
    }

    public int getLowerPrice() {
        return lowerPrice;
    }

    public void setLowerPrice(int lowerPrice) {
        this.lowerPrice = lowerPrice;
    }

    public int getHigherPrice() {
        return higherPrice;
    }

    public void setHigherPrice(int higherPrice) {
        this.higherPrice = higherPrice;
    }
}
