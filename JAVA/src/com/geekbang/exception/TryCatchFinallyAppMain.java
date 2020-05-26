package com.geekbang.exception;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import sun.net.idn.StringPrep;

public class TryCatchFinallyAppMain {
    private static int VAL = 0;

    public static void main(String[] args){
        System.out.println(withFinally());
        System.out.println(VAL);
    }

    private static int withFinally(){
        int len = 0;
        try{
            String s = null;
            return s.length();
        } catch(Exception ex){
            len = -1;
            System.out.println("执行catch里的return语句");
            return len;
        } finally {
            // >>TODO 可以认为finally语句在方法返回后，后面的方法开始前，会在return语句后
            // >>TODO 无论是因为return结束还是因为异常结束，finally语句都会执行
            System.out.println("执行finally语句");
            return -2;
//             >>TODO finally里给return用的变量值复制没用
//            len = -2;

//            VAL = 999;
//            System.out.println("finally语句执行完毕");
        }
    }
}
