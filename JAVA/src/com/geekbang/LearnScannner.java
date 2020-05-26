package com.geekbang;

import java.math.BigInteger;
import java.util.Scanner;

public class LearnScannner {
    public static void main(String[] args) {
        // TODO Scanner是方便我们从标准输入读取并转换数据类型的类
        // TODO 注释里 @since 1.5 表示它是从JAVA5才开始有的
        Scanner scanner = new Scanner(System.in);

        // TODO 但这并不是说从JAVA5开始，这个类就没有变过
        // TODO 在源代码里搜索一下@since，会发现很多方法是在后续的 Java 版本中加进去的
        // TODO private方法不会给这个标识，因为private方法本来就不给用

        System.out.println("请输入一个巨大的正数");
        BigInteger bigInteger = scanner.nextBigInteger();
        System.out.println("请输入想给这个数加多少");
        BigInteger toBeAdd = scanner.nextBigInteger();
        System.out.println("结果为：" + bigInteger.add(toBeAdd));
    }
}
