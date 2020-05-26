package com.geekbang;

import com.geekbang.supermarket.Merchandise;
import com.geekbang.supermarket.Phone;
import com.geekbang.supermarket.ShellColorChangePhone;

public class MerchandiseTest {

    public void testMerchandiseOverload(Merchandise merchandise){
        System.out.println("参数为Merchandise的testMerchandiseOverload 被调用了");
    }

    public void testMerchandiseOverload(Phone phone){
        System.out.println("参数为Phone的testMerchandiseOverload 被调用了");
    }

    public void testMerchandiseOverload(ShellColorChangePhone colorChangePhone){
        System.out.println("参数为ShellColorChangePhone的testMerchandiseOverload 被调用了");
    }

    public void testMerchandiseOverload(String ss){
        System.out.println("参数为String的testMerchandiseOverload 被调用了");
    }

    public void testMerchandiseOverloadNotExactlyMatchType(Merchandise merchandise){
        System.out.println("参数为Merchandise的testMerchandiseOverloadNotExactlyMatchType 被调用了");
    }

//    public void testMerchandiseOverloadNotExactlyMatchType(Phone phone){
//        System.out.println("参数为Phone的testMerchandiseOverloadNotExactlyMatchType 被调用了");
//    }

    public void testMerchandiseOverloadNotExactlyMatchType(String ss){
        System.out.println("参数为String的testMerchandiseOverloadNotExactlyMatchType 被调用了");
    }

}
