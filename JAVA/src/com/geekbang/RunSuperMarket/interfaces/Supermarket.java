package com.geekbang.RunSuperMarket.interfaces;

public interface Supermarket {
    Merchandise[] getAllMerchandise();

    Merchandise[] getRandomMerchandiseOfCategory(Category category);

    void addEarnedMoney(double earnedMoney);

    void dailyReport();
}
