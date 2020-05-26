package com.geekbang;

import com.geekbang.supermarket.LittleSuperMarket;
import com.geekbang.supermarket.Merchandise;
import com.geekbang.supermarket.ShellColorChangePhone;

import javax.print.DocFlavor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionAppMain {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        LittleSuperMarket superMarket = new LittleSuperMarket("大卖场",
                "世纪大道1号", 500, 600, 100);

        Merchandise m100 = superMarket.getMerchandiseOf(100);

        // >>TODO 获得Class实例的两个方法：1、类名点class;2、实例.getClass()
        Class clazz = Merchandise.class;

        Field countField = clazz.getDeclaredField("count");
        countField.setAccessible(true);
        System.out.println("通过反射获取count的值:" + countField.get(m100));
        countField.set(m100,50);
        System.out.println("通过反射获取count的值:" + countField.get(m100));
//        Field field = clazz.getField("STATIC_NUMBER");
//        System.out.println(field.get(null));

//        printFiled(clazz);

//        Method describeMethod = clazz.getMethod("describe");
//        describeMethod.invoke(m100);
//        describeMethod.invoke(superMarket.getMerchandiseOf(10));


//        Method buyMethod = clazz.getMethod("buy", int.class);
//        System.out.println(buyMethod.invoke(m100,10));





    }

    public static void printFiled(Class clazz){
        System.out.println(clazz.getName() + "里的field:");
        for(Field field : clazz.getFields()){
            System.out.println(field.getType() + " " + field.getName());
        }
    }
}
