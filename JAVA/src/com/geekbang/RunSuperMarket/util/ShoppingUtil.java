package com.geekbang.RunSuperMarket.util;

import com.geekbang.RunSuperMarket.impl.*;
import com.geekbang.RunSuperMarket.interfaces.Category;
import com.geekbang.RunSuperMarket.interfaces.Customer;
import com.geekbang.RunSuperMarket.interfaces.Merchandise;
import com.geekbang.RunSuperMarket.interfaces.Supermarket;

import java.util.Scanner;

public class ShoppingUtil {
    private static final Scanner in = new Scanner(System.in);

    public static Scanner input() {
        return in;
    }

    public static void output(Object object) {
        System.out.println(String.valueOf(object));
    }

    public static Supermarket createSuperMarket() {
        int merchandisePerCategory = 10;
        Merchandise[] all = new Merchandise[Category.values().length * merchandisePerCategory];

        for (Category category : Category.values()) {
            for (int i = 0; i < merchandisePerCategory; i++) {
                double soldPrice = Math.random() * (category.getHigherPrice() - category.getLowerPrice())
                        + category.getLowerPrice();

                double purchasePrice = soldPrice * 0.7;

                all[category.ordinal() * merchandisePerCategory + i] = new SimpleMerchandise(category.name() + i,
                        soldPrice, purchasePrice, 200, category);
            }
        }
        SimpleSuperMarket simpleSuperMarket = new SimpleSuperMarket(all);
        output("请输入超市名字");
        String s = input().next();
        if (s.trim().length() > 0) {
            simpleSuperMarket.setName(s);
        }
        return simpleSuperMarket;
    }

    public static Customer createCustomer(boolean auto){
        if(auto){
            String custId = "CUST" + (int)(Math.random() * 10000);
            Category shouldBuy = getRandomCategory();
            if(Math.random() < 0.5){
                return new SuiYuanCustomer(custId,shouldBuy);
            }else{
                ThinkAndBuyCustomer ret = new ThinkAndBuyCustomer(custId,shouldBuy);
                ret.setCard(getRandomVipCard());
                return ret;
            }
        }
        return null;
    }

    public static Category getRandomCategory(){
        return Category.values()[(int) (Math.random()*1000) % Category.values().length];
    }

    public static VIPCard getRandomVipCard(){
        return VIPCard.values()[(int) (Math.random()*1000) % VIPCard.values().length];
    }
}

