package com.geekbang.RunSuperMarket.impl;

import com.geekbang.RunSuperMarket.interfaces.Card;
import com.geekbang.RunSuperMarket.interfaces.Customer;
import com.geekbang.RunSuperMarket.interfaces.ShoppingCart;

public class CashCard implements Card {

    // 1:1抵扣现金的点数
    private double point;

    public CashCard(double point){
        this.point = point;
    }
    @Override
    public double processCardDiscount(double totalCost, double totalCostAfterDiscount,
                                      Customer customer, ShoppingCart shoppingCart) {
        if(totalCostAfterDiscount < point){
            point -= totalCostAfterDiscount;
            return totalCostAfterDiscount;
        } else {
            // 否则就抵扣掉所有的点
            double point_original = point;
            point = 0;
            return point_original;
        }
    }
}
