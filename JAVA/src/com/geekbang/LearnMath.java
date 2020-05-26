package com.geekbang;

import java.util.Random;

public class LearnMath {

    public double abc;

    public static void main(String[] args){
        // TODO 我们调用的就是Math的静态方法，Math的构造方法就是private的，因此不能创建Math的实例
        System.out.println(Math.random());
        // TODO 归根结底，random()方法使用Random类来实现的，它在java.util包里
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            // TODO nextInt的返回值竟然有正数有负数哦！所以使用别人的类之前，一定要看看文档，避免出问题
            System.out.println(Math.abs(random.nextInt()));
        }

        System.out.println(Math.abs(-9));

        System.out.println(Math.round(-9.2));
        System.out.println(Math.round(-9.5));
        System.out.println(Math.round(-9.8));
        System.out.println(Math.round(9.2));
        System.out.println(Math.round(9.5));
        System.out.println(Math.round(9.8));

    }
}
