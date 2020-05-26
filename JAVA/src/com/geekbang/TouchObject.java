package com.geekbang;

import com.geekbang.supermarket.LittleSuperMarket;
import com.geekbang.supermarket.Merchandise;

import java.util.Objects;

public class TouchObject {
    public static void main(String[] args){
        Object object = new Object();
        printObj(object);

        LittleSuperMarket superMarket = new LittleSuperMarket("大卖场",
                "世纪大道1号", 500, 600, 100);

        printObj(superMarket);

        printObj(superMarket.getMerchandiseOf(0));
        printObj(superMarket.getMerchandiseOf(10));
        printObj(superMarket.getMerchandiseOf(100));
        Object a = superMarket;
        Object b = new LittleSuperMarket("大卖场",
                "世纪大道1号", 500, 600, 100);
        System.out.println(Objects.equals(a,b));
    }

    private static void printObj(Object object){
        System.out.println("-----" + object + "的详细内容-----");
        System.out.println(object);
        System.out.println(object.toString());
        System.out.println(object.getClass());
        System.out.println(object.hashCode());


    }
}
