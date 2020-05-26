package com.geekbang.supermarket;

import java.util.Date;

public abstract class AbstractExpireDateMerchandise extends Merchandise implements ExpireDateMerchandise {

    private Date produceDate;
    private Date expirationDate;

    public AbstractExpireDateMerchandise(String name, String id, int count, double soldPrice, double purchasePrice, Date produceDate, Date expirationDate) {
        super(name, id, count, soldPrice, purchasePrice);
        this.produceDate = produceDate;
        this.expirationDate = expirationDate;
    }

    public AbstractExpireDateMerchandise(String name, String id, int count, double soldPrice, Date produceDate, Date expirationDate) {
        super(name, id, count, soldPrice);
        this.produceDate = produceDate;
        this.expirationDate = expirationDate;
    }

    public AbstractExpireDateMerchandise(Date produceDate, Date expirationDate) {
        this.produceDate = produceDate;
        this.expirationDate = expirationDate;
    }

    public boolean notExpireInDate(int days) {
        return daysBeforeExpire() > 0;
    }

    @Override
    public Date getProduceDate() {
        return produceDate;
    }


    public Date getExpireDate() {
        return expirationDate;
    }

    public double leftDatePercentage() {
        return 1.0 * daysBeforeExpire() / (daysBeforeExpire() + daysAfterProduce());
    }

    // >>TODO 抽象类自己定义的抽象方法，可以是protected，也可以是缺省，但不能是private，这点和接口不同
//    protected abstract void test();

    private long daysBeforeExpire() {
        long expireMS = expirationDate.getTime();
        long left = expireMS - System.currentTimeMillis();
        if (left < 0) {
            return -1;
        }
        return left / (24 * 3600 * 1000);
    }

    private long daysAfterProduce() {
        long produeMS = produceDate.getTime();
        long past = System.currentTimeMillis() - produeMS;
        if (past < 0) {
            return -1;
        }
        return past / (24 * 3600 * 1000);
    }
}
