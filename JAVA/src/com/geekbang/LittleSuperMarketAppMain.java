package com.geekbang;

import com.geekbang.supermarket.LittleSuperMarket;
import com.geekbang.supermarket.Merchandise;
import com.geekbang.supermarket.ShellColorChangePhone;

import javax.print.DocFlavor;

public class LittleSuperMarketAppMain {
    public static void main(String[] args){
        LittleSuperMarket superMarket = new LittleSuperMarket(
                "大卖场","世纪大道1号", 500, 600, 100);

        Merchandise m0 = superMarket.getMerchandiseOf(0);
        m0.describe();
        System.out.println();
        Merchandise m100 = superMarket.getMerchandiseOf(100);
        m100.describe();
        System.out.println();
        Merchandise m10 = superMarket.getMerchandiseOf(10);
        m10.describe();
        System.out.println();



    }
}
