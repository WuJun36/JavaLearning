package com.geekbang;

import com.geekbang.supermarket.LittleSuperMarket;
import com.geekbang.supermarket.Merchandise;
import com.geekbang.supermarket.Phone;
import com.geekbang.supermarket.ShellColorChangePhone;

public class InstanceOfTestAppMain {
    public static void main(String[] args) {
        int merchandiseCount = 600;
        LittleSuperMarket superMarket = new LittleSuperMarket("大卖场",
                "世纪大道1号", 500, merchandiseCount, 100);

//        // >>TODO instance操作符，可以判断一个引用指向的对象是否是某个类型或者其子类型
//        // >>TODO 是返回true ,否则返回false
//        for (int i = 0; i < superMarket.getMerchandises().length; i++) {
//            Merchandise m = superMarket.getMerchandiseOf(i);
////            Merchandise m = null;
//            if( m instanceof Merchandise){
//                // TODO 先做判断，再强制类型转换比较安全
//                Merchandise ph = (Merchandise) m;
//                System.out.println(ph.getName());
//            } else {
//                System.out.println("not an instance");
//            }
//        }
//
//        // >>TODO 如果引用是null ，这肯定返回false.

        Merchandise m0 = superMarket.getMerchandiseOf(0);
        Merchandise m10 = superMarket.getMerchandiseOf(10);
//        Merchandise ccm = new Phone();
        Merchandise m100 = superMarket.getMerchandiseOf(100);

        System.out.println(m0 instanceof Phone);
        System.out.println(m10 instanceof Phone);
        System.out.println(m100 instanceof Phone);
    }
}
