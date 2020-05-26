package com.geekbang.RunSuperMarket.impl;

import com.geekbang.RunSuperMarket.interfaces.Card;
import com.geekbang.RunSuperMarket.interfaces.Category;
import com.geekbang.RunSuperMarket.interfaces.HasCard;
import com.geekbang.RunSuperMarket.interfaces.Merchandise;

public class ThinkAndBuyCustomer extends AbsCustomer implements HasCard {

    private Card card = VIPCard.Level0;

    public ThinkAndBuyCustomer(String custId, Category sholdBuy) {
        super(custId, sholdBuy, DEFAULT_GUANG_COUNT);
    }

    @Override
    public int buyMerchandise(Merchandise merchandise) {
        Category category = merchandise.getCategory();
        if (category == getShouldBuy()) {
            return 1;
        }
        double soldPrice = merchandise.getSoldPrice();
        double avgPrice = (category.getHigherPrice() + category.getLowerPrice()) / 2;

        if (soldPrice < avgPrice){
            return 1;
        } else{
            return 0;
        }
    }

    @Override
    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
