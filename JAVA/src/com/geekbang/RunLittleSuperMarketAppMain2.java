package com.geekbang;

import com.geekbang.supermarket.LittleSuperMarket;
import com.geekbang.supermarket.Merchandise;

import java.util.Scanner;

public class RunLittleSuperMarketAppMain2 {
    public static void main(String[] args) {
        // 创建一个小超市类
        LittleSuperMarket littleSuperMarket = new LittleSuperMarket();
        // 依次给超市的名字，地址，停车位赋值
        littleSuperMarket.setSuperMarketName("有家小超市");
        littleSuperMarket.setAddress("岳麓大道777号");
        littleSuperMarket.setParkingCount(100);
        // 给超市200种商品
        littleSuperMarket.setMerchandises(new Merchandise[200]);
        // 统计用的数组
        littleSuperMarket.setMerchandiseSold(new int[littleSuperMarket.getMerchandises().length]);

        // 为了方便使用，创建一个商品数组引用，和littleSuperMarket.merchandise指向同一个数组对象
        Merchandise[] all = littleSuperMarket.getMerchandises();


        // 遍历，并给200种商品赋值
        for (int i = 0; i < all.length; i++) {
            //创建，并给商品的属性赋值
            double purchasePrice = Math.random() * 200;
            Merchandise m = new Merchandise("商品" + i, "ID" + i,200, purchasePrice, purchasePrice * (1 + Math.random()));
            // 用创建的商品，给商品数组的第i个引用赋值，all和小超市的商品数组引用指向的是同一个数组对象
            all[i] = m;
        }


        Merchandise bigPorfit = littleSuperMarket.getBiggestProfitMerchandise();
        bigPorfit.describe();
        // >>TODO 使用别的类的静态变量时，需要使用完整形态：类名.静态变量名
        // >>TODO 静态变量再整个JAVA程序中只有一个（对比实例变量，是每个实例变量有一份
        // >>TODO 所以静态变量一旦发生变化，所有使用这个静态变量的地方都会发生变化
//        Merchandise.DISCOUNT_FOR_VIP = 0.5;
        bigPorfit.describe();

        System.out.println("VIP折上折为" + Merchandise.getDiscountOnDiscount(littleSuperMarket));

        Scanner scanner = new Scanner(System.in);
        Merchandise m0 = all[0];
        while (true) {
            System.out.println("今日超市大特惠，所有商品第二件半价！选择要购买的商品索引：");
            int index = scanner.nextInt();
            if (index < 0) {
                System.out.println("欢迎再次光临！");
                break;
            }

            System.out.println("请输入要购买的数量：");
            int count = scanner.nextInt();

            Merchandise m = littleSuperMarket.getMerchandises()[index];
            System.out.println("用户选择的商品是超市里价值最高的：" + m.isTheBiggestTotalValueOne(littleSuperMarket));
            double totalCost = m.buyAndPrintLeft(count, true);

            boolean m0BiggerThan = m0.totalValueBiggerThan(m);
            System.out.println("m0的总价值比用户选择的要大：" + m0BiggerThan);
            System.out.println("商品总价为：" + totalCost);
        }
    }
}
