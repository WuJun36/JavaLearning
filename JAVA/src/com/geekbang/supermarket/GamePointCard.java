package com.geekbang.supermarket;

import java.util.Date;

// >>TODO 一个类只能继承一个父类，但是可以实现多个接口
// >>TODO 如果实现的接口里定义了一样的方法，那么也没问题。但是要求方法名，参数，返回值都必须一模一样
public class GamePointCard extends Merchandise implements ExpireDateMerchandise, VirtualMerchandise {

    private Date produceDate;
    private Date expirationDate;

    public GamePointCard(String name, String id, int count, double soldPrice, double purcePrice, Date produceDate, Date expirationDate) {
        super(name, id, count, soldPrice, purcePrice);
        this.produceDate = produceDate;
        this.expirationDate = expirationDate;

    }

    // >>TODO 一个类实现接口，就是从接口继承了抽象方法
    @Override
    public boolean notExpireInDate(int days) {
        return daysBeforeExpire() > days;
    }

    @Override
    public Date getProduceDate() {
        return produceDate;
    }

    @Override
    public Date getExpireDate() {
        return expirationDate;
    }

    @Override
    public double leftDatePercentage() {
        return 1.0 * daysBeforeExpire() / (daysBeforeExpire() + daysAfterProduce());
    }

    @Override
    public double actualValueNow(double leftDatePercentage) {
        return getSoldPrice();
    }

    private long daysBeforeExpire() {
        long expireMS = expirationDate.getTime();
        long left = expireMS - System.currentTimeMillis();
        if (left < 0) {
            return -1;
        }

        // 返回值是long,是根据left的类型决定的
        return left / (24 * 3600 * 1000);
    }

    private long daysAfterProduce() {
        long produceMS = produceDate.getTime();
        long left = System.currentTimeMillis() - produceMS;
        if (left < 0) {
            return -1;
        }

        // 返回值是long,是根据left的类型决定的
        return left / (24 * 3600 * 1000);
    }
}
