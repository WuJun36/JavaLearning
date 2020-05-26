package com.geekbang.exception;

import jdk.nashorn.internal.codegen.CompilerConstants;

public class CallerRTExceptionAppMain {
    public static void main(String[] args){
        makeCall();
    }

    static void makeCall(){
        // >>TODO RunTimeException，也就是unchecked exception不强制处理，所以冷不丁遇到一个RunTimeException，程序会失败
        Caller1 caller1 = new Caller1();
        System.out.println("调用开始");
        caller1.call2RTException();
        System.out.println("调用结束");
    }
}
