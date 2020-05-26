package com.geekbang.RunSuperMarket.interfaces;

// >>TODO 某一个种类的商品，满多少减多少
// >>TODO 某一个种类的商品，第二件半价

/**
 * 超市的折扣策略
 */
public interface DiscountStrategy {

    /**
     *
     * @param shoppingCart
     * @return 因此折扣策略所扣掉的钱，注意不是折扣后的总价
     */
    double discount(ShoppingCart shoppingCart);

}
