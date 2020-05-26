package com.geekbang;

import com.geekbang.supermarket.LittleSuperMarket;
import com.geekbang.supermarket.Merchandise;
import com.geekbang.supermarket.Phone;
import com.geekbang.supermarket.ShellColorChangePhone;

public class OverloadTestAppMain {
    public static void main(String[] args) {
        LittleSuperMarket superMarket = new LittleSuperMarket("大卖场",
                "世纪大道1号", 500, 600, 100);

        Merchandise m = superMarket.getMerchandiseOf(100);  //Merchandise引用，ShellColorChangePhone对象

        MerchandiseTest merchandiseTest = new MerchandiseTest();
        // >>TODO 重载调用哪个方法，和参数的引用类型相关，和引用实际指向的类型无关
        System.out.println("----------------1--------------------");
        merchandiseTest.testMerchandiseOverload(m);
        merchandiseTest.testMerchandiseOverload((Phone) m);
        merchandiseTest.testMerchandiseOverload((ShellColorChangePhone) m);
        // TODO 重载的参数类型，相同位置，不一定要有继承或者兼容的关系，完全freeStyle
        merchandiseTest.testMerchandiseOverload("");

        // >>TODO 甚至是个null都行，但要做强制类型转换，告诉JAVA这个类型是什么，否则找不到一个唯一的方法去调用

        System.out.println("----------------2-------------------");

        System.out.println();
        // >>TODO 引用本身是null没有关系，确定调用哪个方法只需要引用的类型，这叫做静态多态，即在编译器就知道要调用哪个方法
        m = null;
        merchandiseTest.testMerchandiseOverload(m);
        merchandiseTest.testMerchandiseOverload((Phone) m);
        merchandiseTest.testMerchandiseOverload((ShellColorChangePhone) m);

        System.out.println("----------------3-------------------");
        // TODO 如果引用类型没有完全匹配的，则会根据继承关系，沿着参数当前的类型，往下撸
        merchandiseTest.testMerchandiseOverloadNotExactlyMatchType((ShellColorChangePhone) null);

        // TODO 重载总结：静态多态，和参数实际指向的对象无关，只和引用本身的类型相关
        // TODO 因为调用时参数类型是确定的，所以，在编译期间就可以明确的知道哪个方法会被调用。如果有多种可能，就会报错
        // TODO 如果没有完全匹配的参数类型，就会根据继承关系往下撸，找到最贴近参数类型的那个方法
        // TODO 无论是静态方法，还是成员方法，重载寻找方法的顺序是一样的，在这里就不赘述了
    }
}
