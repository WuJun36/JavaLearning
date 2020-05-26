package com.geekbang;

import com.geekbang.supermarket.LittleSuperMarket;
import com.geekbang.supermarket.Merchandise;
import com.geekbang.supermarket.ShellColorChangePhone;

import javax.swing.plaf.SeparatorUI;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassOfClassAppMain {
    public static void main(String... args) throws NoSuchFieldException, NoSuchMethodException {
        LittleSuperMarket superMarket = new LittleSuperMarket("大卖场",
                "世纪大道1号", 500, 600, 100);
        Merchandise m100 = superMarket.getMerchandiseOf(100);

        // >>TODO Object类里的getClass方法，可以得到
//        Class clazz = ShellColorChangePhone.class;
        Class clazz = m100.getClass();
//        System.out.println(clazz.getName());
//        System.out.println(clazz.getSimpleName());
//        System.out.println(clazz.toString());

        // >>TODO 通过一个类的classs实例，可以获取一个类的全部信息，包括成员变量，方法等
        Field countField = clazz.getField("count");
//        countField.getName();
        System.out.println(countField.getType());
//        Field nameFiled = clazz.getField("name");

        Method equalMethod = clazz.getMethod("equals", Object.class);
        Method buyMethod = clazz.getMethod("buy", int.class);
        System.out.println(equalMethod.getParameters()) ;


    }
}
