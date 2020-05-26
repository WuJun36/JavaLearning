package com.geekbang;

import com.geekbang.supermarket.Merchandise;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import static com.geekbang.supermarket.Merchandise.*;
//import static com.geekbang.supermarket.Merchandise.getDiscountForVip;

public class MerchandiseDescAppMain {
    public static void main(String[] args){
        Merchandise m= new Merchandise("书桌", "DESK9527", 40, 999.9, 500);
        m.describe();


        // >>TODO 使用import static来引用一个静态变量(方法），就可以直接用静态变量访问了
        // >>TODO import static也可以使用通用符*来引入一个类里所用静态变量（方法）
        System.out.println(DISCOUNT_FOR_VIP);
        System.out.println(getDiscountForVip());

        Merchandise merchandiseCreateByStatic =  Merchandise.createMerchandise("书桌", "DESK9527", 40, 999.9, -500);
        System.out.println(merchandiseCreateByStatic);
    }
}

