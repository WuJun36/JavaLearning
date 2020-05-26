package com.geekbang.supermarket;

public class MerchandiseAppMain {
    public static void main(String[] args){
        Merchandise merchandise = new Merchandise("书桌","DESK1028",50,2499.9,1500);

        merchandise.describe();

        Merchandise merchandise1 = new Merchandise();
        merchandise1.describe();


        // 使用int调用参数为double的方法
        int count = 3;
//        merchandise.buyDouble(count);

        System.out.println("测试使用不完全匹配的参数调用重载方法");
        // >>TODO 依次使用byte,short,int,long,float,double类型的参数调用buy方法，哪个方法会被调用？
        // >>TODO 无论是否重载参数类型可以不完全匹配的规则是“实参数可以自动转换为形参类型”
        // >>TODO 重载的特殊之处是，参数满足自动类型转换的方法有好几个，重载是选择最近的去调用
        byte countForOverride = 11;
        merchandise.buy(countForOverride,true);
    }
}
