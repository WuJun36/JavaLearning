package com.geekbang;

import com.geekbang.supermarket.Merchandise;
import com.geekbang.supermarket.Phone;
import com.geekbang.supermarket.ShellColorChangePhone;

public class ReferenceAssign {
    public static void main(String[] args){
        Phone ph = new Phone(
                "手机001", "Phone001", 100, 1999, 999,
                4.5, 3.5, 4, 128, "索尼", "安卓",null);

        // >>TODO 可以用子类的引用给父类的引用赋值，也就是说父类的引用可以指向子类的对象

        Merchandise m = ph;
        Merchandise m2 = new Phone(
                "手机002", "Phone002", 100, 1999, 999,
                4.5, 3.5, 4, 128, "索尼", "安卓",null);

        // >>TODO 反之则不行，不能让子类的引用指向父类的对象。因为父类并没有子类的属性和方法
//        Phone notDoAble = new Merchandise();

        // >> TODO                          重点
        // >>TODO 因为子类继承了父类的方法和属性，所以父类对象能做的，子类对象也一定可以
        // >>TODO 换句话说，我们可以在子类的对象上执行父类的操作
        // >>TODO 当父类的引用指向子类的实例（或父类的实例），只能通过父类的引用，像父类一样操作子类的对象
        // >>TODO 也就是说，名的类型，决定了能执行哪些操作

        // >>TODO ph和m都指向同一个对象，通过ph能调用getBrand()方法
        //   TODO 因为ph的类型是Phone,Phone里面定义了getBrand()方法
        ph.getBrand();
        // >>TODO ph和m都指向同一个对象，但是通过m就不能调用getBrand()方法
        // >>TODO 因为m的类型是Merchandise，Merchandise里没有定义的getBrand()方法
//        m.getBrand();

        // TODO 如果确定一个父类的引用指向的对象，实际上就是一个子类的对象（或者是子类的子类的对象），可以强制类型转换
        Phone aPhone = (Phone) m2;

        // Merchandise是Phone的父类，Phone是ShellColorChangePhone的父类
        ShellColorChangePhone shellColorChangePhone = new ShellColorChangePhone("手机002", "Phone002", 100, 1999, 999,
                4.5, 3.5, 4, 128, "索尼", "安卓",null);

        // >>TODO 父类的引用可以指向子类的对象，即可以用子类（或子类的子类）的引用给父类的引用赋值
        Merchandise ccm = shellColorChangePhone;

        // >>TODO 父类的引用可以指向子类的对象
        //   TODO  确定Merchandise的引用ccm指向的是Phone或者Phone的子类对象，那么可以强制类型转换
        Phone ccp = (Phone) ccm;

        // TODO 确定MerchandiseV2的引用ccm是指向的是ShellColorChangePhone或者ShellColorChangePhone的子类对象
        // TODO 那么可以强制类型转换
        ShellColorChangePhone scp = (ShellColorChangePhone) ccm;

        // TODO 会出错，因为m2是一个Phone的对象，不是ShellColorChangePhone
//        ShellColorChangePhone notCCP = (ShellColorChangePhone) m2;


    }
}
