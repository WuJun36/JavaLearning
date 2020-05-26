package com.geekbang;

import com.geekbang.supermarket.LittleSuperMarket;
import com.geekbang.supermarket.Merchandise;
import com.geekbang.supermarket.Phone;

public class TestFinalRefAppMain {
    public static void main(String[] args){
        LittleSuperMarket superMarket = new LittleSuperMarket("大卖场",
                "世纪大道1号", 500, 600, 100);
        Phone ph = (Phone)superMarket.getMerchandiseOf(10);
        Merchandise gift = ph.getGift();

        gift.describe();
        gift.setName("变化一下商品名字？");
        gift.setSoldPrice(9999);
        gift.describe();

        Merchandise m0 = superMarket.getMerchandises()[0];
        superMarket.getMerchandises()[0] = gift;
        Merchandise m0Change =  superMarket.getMerchandises()[0];

        m0.describe();
        m0Change.describe();

    }
}
