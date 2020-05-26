package com.geekbang.RunSuperMarket;

import com.geekbang.RunSuperMarket.impl.SimpleShopMan;
import com.geekbang.RunSuperMarket.interfaces.Customer;
import com.geekbang.RunSuperMarket.interfaces.ShopMan;
import com.geekbang.RunSuperMarket.interfaces.Supermarket;

import static com.geekbang.RunSuperMarket.util.ShoppingUtil.*;

public class ShoppingAppMain {
    public static void main(String[] args) {
        Supermarket supermarket = createSuperMarket();

        ShopMan shopMan = new SimpleShopMan(supermarket);

        boolean open = true;
        while (open) {
            new ShoppingTask(shopMan).executeTask();
            output("是否继续营业？(Yes)");
            open = ! input().next().trim().equalsIgnoreCase("no");

        }

        supermarket.dailyReport();

    }
}

class ShoppingTask{
    private ShopMan shopMan;

    public ShoppingTask(ShopMan shopMan){
        this.shopMan = shopMan;
    }

    public void executeTask(){
        Customer customer = createCustomer(true);


    }
}