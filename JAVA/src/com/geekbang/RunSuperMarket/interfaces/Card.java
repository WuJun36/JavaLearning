package com.geekbang.RunSuperMarket.interfaces;

public interface Card {

    /**
     * 执行完超市自身的打折策略后，确定了顾客要付多少钱
     * 然后根据顾客是否有VIP卡，判断是否继续打折，看顾客是否有现金卡，抵扣现金
     * @param totalCost                 商品原价总价
     * @param totalCostAfterDiscount    执行完超市的打折策略后的总价
     * @param customer                  购买的顾客
     * @param shoppingCart              购物车
     * @return  优惠额，注意不是优惠后的价格
     */
    double processCardDiscount(double totalCost, double totalCostAfterDiscount,
                               Customer customer, ShoppingCart shoppingCart);
}
