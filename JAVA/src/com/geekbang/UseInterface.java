package com.geekbang;

import com.geekbang.supermarket.ExpireDateMerchandise;
import com.geekbang.supermarket.GamePointCard;
import com.geekbang.supermarket.Merchandise;
import com.geekbang.supermarket.VirtualMerchandise;

import java.util.Date;

public class UseInterface {
    public static void main(String[] args) {
        Date produceDate = new Date();

        Date expireDate = new Date(produceDate.getTime() + 365L * 24 * 3600 * 1000);
        GamePointCard gamePointCard = new GamePointCard("手机001",
                "Phone001",100,1999,999,produceDate,expireDate);

        // >>TODO 可以用实现接口的类的引用，给接口的引用赋值，类似于可以使用子类的引用给父类复制
        ExpireDateMerchandise expireDateMerchandise = gamePointCard;

        VirtualMerchandise virtualMerchandise = gamePointCard;

        Merchandise m = gamePointCard;

        expireDateMerchandise = (ExpireDateMerchandise) m;

        virtualMerchandise = (VirtualMerchandise) m;

        if(m instanceof  ExpireDateMerchandise){
            System.out.println("m 是 ExpireDateMerchandise 类型的实例");
        }

        if(m instanceof VirtualMerchandise){
            System.out.println("m 是 VirtualMerchandise 类型的实例");
        }
        int days = 500;
        System.out.println(gamePointCard.notExpireInDate(days));
    }
}
