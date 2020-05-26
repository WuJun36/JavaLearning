package com.geekbang.learnboxandunbox;

import java.util.HashMap;
import java.util.Map;

public class WrapperClassesForNumberPrimaryTypesAppMain {
    public static void main(String[] args){
        int a = 99;

        Integer i1 = new Integer(a);
        Integer i2 = new Integer("789");
        int b = Integer.valueOf(a);
        int c = Integer.parseInt("998");

        System.out.println("---------------自动封箱拆箱--------------");
        // >>TODO Java提供了自动为每种基本数据类型和其封装类之间的转换功能
        // >>TODO 从基本数据类型到封装类，叫做自动封箱（auto boxing)，从封装类到基本数据类型，叫做自动拆箱（auto unboxing)
        Integer ab = 987;
        int cd = ab;

        // TODO 自动封箱为Integer,作为Map中的key
        Map<Integer,String> int2Str = new HashMap<>();
        int2Str.put(1,"壹");
        int2Str.put(2,"贰");
        int2Str.put(3,"叁");
        System.out.println(int2Str.get(1));

        // TODO 自动拆箱为int，并给key赋值
        for(int key : int2Str.keySet()){
            System.out.println(key);
        }

        System.out.println("-----------------有用的方法--------------------");
        System.out.println(Integer.toBinaryString(-1024));
        System.out.println(Integer.toOctalString(-1024));
        System.out.println(Integer.toHexString(-1024));

        System.out.println("-----------------Number类---------------------");

        // TODO 所有和数据相关的封装类，都继承自Number类
        Number num = 9;
        num = new Integer(12345);
        Number numD = 9.99;
        numD = new Double(12.30295);

        // TODO 使用Number类可以方便地进行数字类型的转换
        // TODO 当然所有的类都继承了Number的这些转换方法
        System.out.println("使用number将double转为long：" + numD.longValue());

        System.out.println("----------------自动拆箱可能的NPE-----------------");

        int2Str.put(null,"无");
        System.out.println(int2Str.get(null));

        // TODO 自动拆箱为int，并给key赋值，但是有一个key为null，null是无法转成一个int的，注意，null不是0
        // TODO 其实自动拆箱，后面是Java帮我们调用了对应的方法，在这里就是intValue()这个方法
        // TODO 所以当引用为null时候自动拆箱，相当于是调用null的方法，所以这时候就会发生NPE
        // TODO 对于其他封装类型的自动拆装箱，也是一样的
        for (int key : int2Str.keySet()){
            System.out.println(key);
        }

    }
}
