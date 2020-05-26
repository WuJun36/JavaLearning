package com.geekbang;

import com.geekbang.supermarket.LittleSuperMarket;
import com.geekbang.supermarket.Merchandise;

public class ObjectEqualsAppMain {
    public static void main(String[] args){
        int defaultCount = 200;
        LittleSuperMarket superMarket = new LittleSuperMarket("大卖场",
                "世纪大道1号", 500, 600, defaultCount);
        Merchandise t0 = new Merchandise(
                "商品" + 0,
                "ID" + 0,
                defaultCount,
                1999,
                999
        );

        Merchandise t10 = new Merchandise(
                "商品" + 10,
                "ID" + 10,
                defaultCount,
                1999,
                999
        );

        Merchandise t100 = new Merchandise(
                "商品" + 100,
                "ID" + 100,
                defaultCount,
                1999,
                999
        );

        System.out.println(superMarket.findMerchandise(t0));
        System.out.println(superMarket.findMerchandise(t10));
        System.out.println(superMarket.findMerchandise(t100));
        System.out.println(t100.toString());
    }
}
