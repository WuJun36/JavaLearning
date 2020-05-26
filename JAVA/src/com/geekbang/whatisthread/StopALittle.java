package com.geekbang.whatisthread;

public class StopALittle {
    public static void main(String[] args) throws InterruptedException {
        printSlowly("无所不能威神V,钱锟，李永钦，董思成，黄旭熙，肖俊，黄冠亨，刘扬扬" ,300);
    }

    public  static void printSlowly(String text,long interval) throws InterruptedException {
        for(char ch : text.toCharArray()){
            Thread.sleep(interval);
            System.out.print(ch);
        }
        System.out.println();
    }
}
