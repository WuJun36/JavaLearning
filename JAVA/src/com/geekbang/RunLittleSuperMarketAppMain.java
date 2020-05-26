package com.geekbang;

import com.geekbang.person.Customer;
import com.geekbang.supermarket.LittleSuperMarket;
import com.geekbang.supermarket.Merchandise;
import sun.net.idn.StringPrep;

import java.util.Scanner;

public class RunLittleSuperMarketAppMain {
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
            Merchandise m = new Merchandise("商品" + i, "ID" + i, 200, purchasePrice, purchasePrice * (1 + Math.random()));
            // 用创建的商品，给商品数组的第i个引用赋值，all和小超市的商品数组引用指向的是同一个数组对象
            all[i] = m;
        }

        int index = 0;
        Merchandise m = littleSuperMarket.getMerchandises()[index];
        int c = 7;

        //----------------参数-------------------
        // >>TODO 参数的传递其实就是赋值，左边是形参，右边是实参
        // >>TODO 类似于buy(int countToBuy = (c+2)*5)
        // >>TODO 参数本身可以为表达式，只要表达式的值类型
        double totalCost = m.buy((c + 2) * 5);
        System.out.println("商品的总价为：" + totalCost);

        // >>TODO -对于引用类型，参数同样是一个表达式
        boolean biggerThan = m.totalValueBiggerThan(littleSuperMarket.getMerchandises()[index + 1]);
        System.out.println(biggerThan);

        // >>TODO 方法里的代码并不能改变实参的值
        // >>TODO 方法里使用的参数相当于一个局部变量。使用方法前，会有实参给局部变量赋值
        Merchandise paramRef = littleSuperMarket.getMerchandises()[2];
        int paramPrime = 7;

        System.out.println("调用前");
        System.out.println(paramRef);
        System.out.println(paramPrime);


        int count = 5;
        System.out.println(count / 2 + count % 2);

        System.out.println("超市开张了!");
        boolean open = true;
        Scanner in = new Scanner(System.in);
        while (open) {
            System.out.println("本店叫做：" + littleSuperMarket.getSuperMarketName());
            System.out.println("地址在：" + littleSuperMarket.getAddress());
            System.out.println("共有停车位：" + littleSuperMarket.getParkingCount());
            System.out.println("今天的营业额为：" + littleSuperMarket.getInComingSum());
            System.out.println("共有商品：" + littleSuperMarket.getMerchandises().length);

            Customer customer = new Customer();
            customer.name = "顾客编号" + ((int) (Math.random() * 10000000));
            customer.money = (1 + Math.random()) * 1000;
            customer.isDrivingCar = Math.random() > 0.5;

            System.out.println("下面请利润最高的商品自我介绍");
            littleSuperMarket.getBiggestProfitMerchandise().describe();

            //----------迎客进门-----------
            //开车来的分配车位，没车位就不让进了
            if (customer.isDrivingCar) {
                if (littleSuperMarket.getParkingCount() > 0) {
                    System.out.println("欢迎" + customer.name + "驾车而来。本店已经为您安排了车位，停车免费哦。车位编号为" + littleSuperMarket.getParkingCount());
                    littleSuperMarket.setParkingCount(littleSuperMarket.getParkingCount() - 1);
                } else {
                    System.out.println("不好意思，本店车位已满。欢迎您下次光临");
                    continue;  //不再执行此次循环下面的语句
                }
            } else {
                System.out.println("欢迎" + customer.name + "光临本店");
            }

            //接待此顾客
//            double totalCost = 0;
            while (true) {
                //顾客选商品
                System.out.println("本店提供" + littleSuperMarket.getMerchandises().length + "种商品，请输入您要购买的商品编号：");
                int merchandiseId = in.nextInt();
                // 输入负数表示买好了
                if (merchandiseId < 0) {
                    System.out.println("您本次购买了" + totalCost + "元的商品。欢迎您再次光临。");
                    break;
                }

                if (merchandiseId > littleSuperMarket.getMerchandises().length) {
                    System.out.println("此商品本店没有，欢迎继续挑选");
                    continue;
                }

                // 商品有，问顾客要购买多少个
                Merchandise toBuy = littleSuperMarket.getMerchandises()[merchandiseId];
                System.out.println(toBuy.getName() + "单价" + toBuy.getSoldPrice() + "。请问购买几个？");

                int numToBuy = in.nextInt();
                //不买
                if (numToBuy <= 0) {
                    System.out.println("不买看看也好，欢迎继续选购");
                    continue;
                }
                //买的太多，库存不够
                if (toBuy.getCount() < numToBuy) {
                    System.out.println(toBuy.getName() + "只有" + toBuy.getCount() + "件了,不够" + numToBuy + "。欢迎继续选购");
                    continue;
                }

                //顾客钱不够
                if (customer.money < (numToBuy * toBuy.getSoldPrice() + totalCost)) {
                    System.out.println("您带的钱不够结账，请您理智消费。");
                    continue;
                }
                // 钱也够，货也够
                // 更新顾客此次消费的总额
                totalCost += numToBuy * toBuy.getSoldPrice();
                // 更新商品库存
                toBuy.setCount(toBuy.getCount() - numToBuy);
                // 更新今日销货数量
                littleSuperMarket.getMerchandiseSold()[merchandiseId] += numToBuy;
            }
            //归还车位
            if (customer.isDrivingCar) {
                littleSuperMarket.setParkingCount(littleSuperMarket.getParkingCount()+1);
            }

            //更新数据
            customer.money -= totalCost;
            littleSuperMarket.setInComingSum(littleSuperMarket.getInComingSum() + totalCost);
            System.out.println(customer.name + "共消费" + totalCost + "。欢迎再次光临。");

            System.out.println("请问还继续营业吗？");
            open = in.nextBoolean();
        }

        System.out.println("超市关门啦！");


        System.out.println("今天的营业额为" + littleSuperMarket.getInComingSum() + "。营业统计如下：");
        for (int i = 0; i < littleSuperMarket.getMerchandises().length; i++) {
            int sold = littleSuperMarket.getMerchandiseSold()[i];
            if (sold > 0) {
                Merchandise m0 = littleSuperMarket.getMerchandises()[i];
                double netIncoming = (m0.getSoldPrice() - m.getPurchasePrice()) * sold;
                double incoming = m0.getSoldPrice() * sold;
                System.out.println(littleSuperMarket.getMerchandises()[i].getName() + "售出" + sold + "个。销售额" + incoming + "。毛利润" + netIncoming);
            }
        }
    }

}
