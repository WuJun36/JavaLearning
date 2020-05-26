package com.geekbang.onlinemarket;

import com.geekbang.supermarket.Merchandise;
import com.geekbang.supermarket.Phone;

import javax.management.ObjectName;

public class OnlineSpecialPhone extends Phone {
    public OnlineSpecialPhone(String name, String id, int count, double soldPrice, double purchasePrice,
                              double screenSize, double cpuHZ, int memoryG, int storageG, String brand, String os, Merchandise gift) {
        super(name, id, count, soldPrice, purchasePrice, screenSize, cpuHZ, memoryG, storageG, brand, os,gift);
//        this.screenSize = 99;
    }

    // >>TODO 子类覆盖父类时，不可以用可见性更低的修饰符，但是可以用更高的修饰符
    //   TODO Why?? 因为子类的对象可以赋值给父类的引用。若父类为public,子类为private
    //   TODO 若存在 Phone phone = new OnlineSpecialPhone() 那么phone可以调用getPhoneOfName方法
    //   TODO 但是phone实际指向的对象却不能调用getPhoneOfName方法，相矛盾
    public String getPhoneOfName() {
        return super.getPhoneOfName();
    }
}
