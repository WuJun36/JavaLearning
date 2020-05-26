package com.geekbang.RunSuperMarket.interfaces;

public interface Customer {

    String getCustId();

    /**
     * 购物前的准备
     */
    void startShopping();

    /**
     * @return 顾客想买的商品种类
     */
    Category chooseCategory();

    /**
     * 顾客是否购买此商品
     * @param merchandise 判断是否要购买的商品
     * @return 购买多少个
     */
    int buyMerchandise(Merchandise merchandise);

    /**
     * 顾客觉得买够了，要结账
     * @return true：要结账；false：继续逛
     */
    boolean wantToCheckOut();

    /**
     * 付款
     * @param shoppingCart 此次购买的商品的购物车
     * @param totalCost 打完折扣后的总价
     * @return 成功则返回付款金额，否则返回-1
     */
    double payFor(ShoppingCart shoppingCart,double totalCost);

    /**
     * @return 顾客花的钱
     */
    double getMoneySpent();
}
