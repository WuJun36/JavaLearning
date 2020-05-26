package com.geekbang.supermarket;

import java.util.Date;

public class GamePointCard2 extends AbstractExpireDateMerchandise implements VirtualMerchandise{

    public GamePointCard2(String name, String id, int count, double soldPrice, double purchasePrice, Date produceDate, Date expirationDate) {
        super(name, id, count, soldPrice, purchasePrice, produceDate, expirationDate);
    }

    @Override
    public double actualValueNow(double leftDatePercentage) {
        return super.getSoldPrice();
    }
}
