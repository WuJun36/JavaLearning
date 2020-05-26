package com.geekbang.learnboxandunbox;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class WrapperClassForCharAppMain {
    public static void main(String[] args){
        // TODO char对应的类为Character,里面又很多isXXX方法比较使用，比如判断字符是否为数字
        System.out.println(Character.isDigit('a'));
        System.out.println(Character.isDigit('字'));
        System.out.println(Character.isDigit('0'));
        System.out.println(Character.isDigit('9'));
    }

}
