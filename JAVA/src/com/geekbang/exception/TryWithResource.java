package com.geekbang.exception;

import javafx.scene.chart.ScatterChart;

public class TryWithResource {
    public static void main(String[] args){
        // >>TODO 如果发生了异常，JAVA会自动调用close的方法，将资源关闭
        try(
            MyAutoClosableResource res1 = new MyAutoClosableResource("res1");
            MyAutoClosableResource res2 = new MyAutoClosableResource("res2")
        ) {
            while (true) {
                System.out.println(res1.read());
                System.out.println(res2.read());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
