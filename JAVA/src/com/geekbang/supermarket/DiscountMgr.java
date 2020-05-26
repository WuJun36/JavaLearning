package com.geekbang.supermarket;

import sun.net.idn.StringPrep;

public class DiscountMgr {
    public static void main(String[] args) {
        System.out.println("最终main 方法中使用的SVIP_DISCOUNT是" + SVIP_DISCOUNT);
    }

    public static double BASE_DISCOUNT;
    public static double VIP_DISCOUNT;
    // >>TODO 使用某个静态变量的代码块，必须在静态变量后面
    // >>TODO （但是仅仅赋值没有限制，很妖的语法哈，有些语法就应该在学会的第一时间忘掉它）
    public static double SVIP_DISCOUNT;

    static {
        BASE_DISCOUNT = 0.99;
        VIP_DISCOUNT = 0.85;
        SVIP_DISCOUNT = 0.75;

        // >> TODO 静态代码块里当然可以有任意的合法代码
        System.out.println("静态代码块1里的SVIP_DISCOUNT" + SVIP_DISCOUNT);

        // >> TODO 这段代码在哪个方法中呢？<clinit>，即class init。会在每个class初始化的时候被调用一次
//         SVIP_DISCOUNT = 9/0;
    }

    // >>TODO 其实给静态变量赋值也是放在代码块里，static代码块会有多个，从上到下按照顺序执行
    // >>TODO 可以认为这些代码都被组织到了一个clinit方法里
//    public static double SVIP_DISCOUNT;
    static{
        SVIP_DISCOUNT = 0.5;
        System.out.println("静态代码块1里的SVIP_DISCOUNT" + SVIP_DISCOUNT);
    }

    // >>TODO 静态方法的重载也是一样的，方法签名不一样即可（方法名+参数）
    // >>TODO 判断调用哪个方法，也是根据调用时的参数来决定的
    public static double getDiscount() {
        return BASE_DISCOUNT;
    }

    public static double getDiscount(boolean isVIP) {
        double isVipDiscount = (isVIP ? VIP_DISCOUNT : 1);
        return isVipDiscount * getDiscount();
    }

    public static double getDiscount(int svipLevel) {
        double ret = getDiscount() * VIP_DISCOUNT;
        for (int i = 0; i < svipLevel; i++) {
            ret *= SVIP_DISCOUNT;
        }
        return ret;
    }

    // >>TODO 返回值不算是方法签名，重载的方法可以有完全不同的返回值类型
    public static void getDistcount(String s) {
        System.out.println(s);
    }

    public static int getDiscount(int a, int b) {
        return a > b ? a : b;
    }

    public static boolean getDiscount(int a, int b, int c) {
        return a > b && b > c;
    }

    public static String getDiscount(long abc) {
        return " " + abc;
    }

//    public static void main(String[] args){
//        long abc = 922327203685477580L;
//        System.out.println(getDiscount(true));
//    }

}
