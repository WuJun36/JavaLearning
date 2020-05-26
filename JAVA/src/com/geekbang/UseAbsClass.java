package com.geekbang;

import com.geekbang.supermarket.AbstractExpireDateMerchandise;
import com.geekbang.supermarket.GamePointCard;
import com.geekbang.supermarket.GamePointCard2;

import java.util.Date;

public class UseAbsClass {
    public static void main(String[] args) {
        Date produceDate = new Date();
        Date expireDate = new Date(produceDate.getTime() + 365L * 24 * 3600 * 1000);
        GamePointCard2 gamePointCard2 = new GamePointCard2(
                "点卡001", "点卡001", 100, 1999, 999,
                produceDate, expireDate);

        // >>TODO 父类的引用可以用子类的引用赋值，抽象类也一样
        AbstractExpireDateMerchandise am = gamePointCard2;
        am.describe();
    }
}
