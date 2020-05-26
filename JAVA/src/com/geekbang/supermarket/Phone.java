package com.geekbang.supermarket;

import com.geekbang.supermarket.Merchandise;

// >>TODO 继承要表达的是一种“is-a"的关系，在类的构造世界里，子类是父类的一种特殊构造类型
// >>TODO 组合和继承，是拿到一个问题，设计相应的JAVA类时，不得不面对的灵魂拷问
// >>TODO "xx到底是yy的一种，还是组合了yy","手机是手电筒的一种，还是组合了手电筒"

// >>TODO 继承不是组合，继承也不是为了简单的拿来父类的属性和方法。如果仅仅如此，原封不动的拿来主义，组合也能做到
// >>TODO 继承也不是通过组合的方式来实现的。和组合相比，继承更像是融合
// >>TODO 所谓融合，即二合一，可以互相影响。父类影响子类没问题，子类怎么影响父类？如果限制手机一次最多买5个？

// >>TODO 继承的语法就是类名后面加extends ,加 要继承的类名
// >>TODO 被继承的类叫做父类(Parent Class)，比如本例中的Merchandise
// >>TODO 继承的类叫做子类（Sub Class)，比如本例中的PhoneExtendsMerchandis
// >>TODO JAVA中只允许一个类有一个直接的父类(Parent Class)，即所谓的单继承
// >>TODO 别的类也可以继承子类，比如HuaweiPhone 继承 PhoneExtendsMerchandise
// >>TODO 这时候HuaWeiPhone就是PhoneExtendsMerchandise的子类
// >>TODO 子类继承了父类什么呢？所有属性和方法
// >>TODO 但是子类不能访问父类的private方法和属性（和上面那条对比的理解？？？具备这些方法和属性，但是不能直接访问？？）

// >>TODO final修饰的类不能被继承
//public final class Phone extends Merchandise{
public class Phone extends Merchandise {
    //给Phone增加新的属性和方法
    // >>TODO 使用不同的可见性定义Phone中属性，protected = default + 继承者可见
    // >>TODO 用final修饰成员变量,必须要初始化
    private double screenSize;
    private double cpuHZ;
    private int memoryG;
    private int storageG;
    private String brand;
    private String os;
    private final static int MAX_BUY_ONE_ORDER = 5;
    private final Merchandise gift;
    private CPU cpu;

    public class CPU2{
        final static int abc = 999;

        private String producer;

    }

    // >>TODO 静态内部类，是在类中用static修饰的类
    // >>TODO 静态内部类可以有访问修饰符，和静态变量、静态方法一样，都是类的静态组成部分
    // >>TODO 静态内部类也是类，继承和接口实现都是一样的
    public static class CPU {
        private double speed;
        private String producer;

        public CPU(double speed, String producer) {
            this.speed = speed;
            this.producer = producer;
        }

        public double getSpeed() {
            // >>TODO 静态内部类，代码和这个类本身的访问权限一样，可以访问外部类（Phone)的private属性
            // >>TODO 注意，这并不是说它可以访问private变量
            // >>TODO 静态内部类是静态的，就好像静态方法一样，没有this自引用，可以通过引用访问Phone的private属性
            // 仅作演示性访问
            Phone phone = null;
            phone.memoryG = 0;
            return this.speed;
        }

        public void setSpeed(double speed) {
            this.speed = speed;
        }

        public String getProducer(){
            return this.producer;
        }

        public void setProducer(){
            this.producer = producer;
        }

        @Override
        public String toString() {
            return "CPU{" +
                    "speed=" + speed +
                    ", producer='" + producer + '\'' +
                    '}';
        }
    }

    public void accessStaticClass(){
        // >>TODO 同样，外部类也可以访问静态内部类（CPU）的private属性
        // 仅作演示访问，不具有实际意义
        this.cpu.producer = "";
    }

    // >>TODO 构造方法可以是protected,但是如果是private，子类就不可以覆盖了
    // >>TODO 如果父类只有一个private的构造方法，相当于这个类不能有子类。（子类的构造方法会在第一行调用父类的构造方法）
    // >>TODO 构造方法不能用final修饰
    public Phone(String name, String id, int count, double soldPrice, double purchasePrice,
                 double screenSize, double cpuHZ, int memoryG, int storageG, String brand, String os, Merchandise gift) {
        // >>TODO 使用super调用父类构造方法，必须是子类构造方法的第一个语句
        // >>TODO 可以使用表达式
        // >>TODO super调用父类的构造方法，不可以使用super访问父类的属性和方法，不可以使用子类成员变量和方法
        // >>TODO 可以使用静态变量和方法
        super(name, id, count, soldPrice, purchasePrice);
        // >>TODO 可以认为，创建子类对象时，也就同时创建了一个隐藏的父类对象
        this.screenSize = screenSize;
        this.cpuHZ = cpuHZ;
        this.memoryG = memoryG;
        this.storageG = storageG;
        this.brand = brand;
        this.os = os;
        this.gift = gift;
        // >>TODO 可以像平常的类一样使用静态内部类
        this.cpu = new CPU(cpuHZ,"Default");
        // TODO 所以才能使用setName()，对name属性进行操作
//        this.setName(name);
//        this.setId(id);
//        this.setCount(count);
//        this.setSoldPrice(soldPrice);
//        this.setPurchasePrice(purchasePrice);


    }

//    public Phone() {
//        super();
//        init(4.5, 4.6, 6, 128, "Uknown", "Uknown");
//    }
//
//    public void init(double screenSize, double cpuHZ, int memoryG, int storageG, String brand, String os,Merchandise gift) {
//        this.screenSize = screenSize;
//        this.cpuHZ = cpuHZ;
//        this.memoryG = memoryG;
//        this.storageG = storageG;
//        this.brand = brand;
//        this.os = os;
//        this.gift = new Merchandise("gift","礼品1",50,0,0);
//    }


    public void describe() {
        System.out.println("此手机商品属性如下：");
        super.describe();
        System.out.println("手机厂商为" + brand + "；系统为" + os + "；硬件配置如下：\n" +
                "屏幕：" + screenSize + "寸\n" +
                "cpu主频" + cpuHZ + " GHz\n" +
                "内存" + memoryG + "Gb\n" +
                "存储空间" + storageG + "Gb\n");
    }

    // >>TODO 通过使用和父类签名一致，而且返回值也必须一样的方法，可以覆盖(Override)掉父类的方法
    // >> TODO ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓下面才是继承的终极奥义↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // >>TODO 也就是说，子类不是仅仅把父类的方法拿来用，而是可以通过覆盖替换掉父类中不适合子类的方法

    // >> TODO ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑上面才是继承的终极奥义↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    // >> TODO 题外话，属性是联动的，可能是有特殊意义的
    // >> TODO 所以直接给属性赋值是危险的，因为没有办法检查新的值是否有意义，也没办法对这个修改做联动的修改

    // >>TODO final修饰的方法不能被覆盖
//    public final double buy(final int count) {
    public double buy(final int count) {

        if (count > MAX_BUY_ONE_ORDER) {
            System.out.println("购买失败，手机一次最多只能买" + MAX_BUY_ONE_ORDER + "个");
            return -2;
        }
        final double cost;
        cost = super.buy(count);
        return cost;
    }

    // >>TODO 返回值也必须与父类一致，不是类型兼容，而是必须一模一样
    //  >>TODO 如果方法签名与父类完全一致，但是返回值不同，会报错
//    public boolean buy(int count){
//        return true;
//    }

    // >>TODO 覆盖可以覆盖父类的方法。同一个方法，不同的行为
    // >>TODO 这，就是多态！
    // >>TODO 方法可以覆盖，但是属性访问不可以，这也是使用方法的一个原因
    // >>TODO 父类眼里这只是一个简单的get方法，但是这样做，子类就可以覆盖掉父类的方法
    // >>TODO 方法不止眼前的代码，还有子类的覆盖。用方法，才能覆盖，才能多态
    public String getName() {
        return this.brand + ":" + this.os + ":" + super.getName();
    }

    protected String getPhoneOfName() {
        return this.brand + ":" + this.os + ":" + super.getName();
    }

    // >>TODO super是子类和父类的交流的桥梁，但是并不是父类的引用（既然super不是父类的引用，那它是什么？）
    // >>TODO 所以，super和this自引用不一样，不是简单可以模拟的（可以模拟的话不就成组合了）
//    public Merchandise getParent(){
//        return super;
//    }
//
//    public Phone getSelf(){
//        return  this;
//    }

    // >>TODO 子类可以使用super调用父类的public,protected成员变量，如果子类和父类在同一包下，则可访问父类的缺省变量
    // >>TODO 但是super不是一个引用
    public void accessParentProps() {
        System.out.println("父类中的name属性：" + super.name);
    }

    public void useSuper() {
        // >>TODO super的用法就像是父类的一个引用。它是继承的一部分，像组合的那部分，但不是全部
        super.describe();
        super.buy(99);
        System.out.println("父类里的count属性：" + super.getCount());
    }

    public boolean meetCondition() {
        return true;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public double getCpuHZ() {
        return cpuHZ;
    }

    public void setCpuHZ(double cpuHZ) {
        this.cpuHZ = cpuHZ;
    }

    public int getMemoryG() {
        return memoryG;
    }

    public void setMemoryG(int memoryG) {
        this.memoryG = memoryG;
    }

    public int getStorageG() {
        return storageG;
    }

    public void setStorageG(int storageG) {
        this.storageG = storageG;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public Merchandise getGift() {
        return gift;
    }

}
