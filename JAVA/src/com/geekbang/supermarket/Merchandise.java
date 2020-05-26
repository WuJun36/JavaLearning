package com.geekbang.supermarket;

import java.util.Objects;

// >>TODO 类、成员变量、成员方法、构造方法、静态变量、静态方法都能用访问修饰符
public class Merchandise {

    // >>TODO 成员变量应该都声明为private
    // >>TODO 如果需要读写成员变量，可以用get,set方法，这些方法应该是public
    // >>TODO 这样的好处是，如果有需要，可以通过代码检查每个属性值是否合法
    protected String name;
    private String id;
    private int count;
    private double soldPrice;
    private double purchasePrice;

    public static String STATIC_NUMBER = "Common Merchandise";

    // >>TODO 静态变量使用static修饰符
    // >>TODO 静态变量如果不赋值，JAVA也会付给其类型的初始值
    // >>TODO 静态变量名一般使用全大写字母加下划线，这是一种习惯
    // >>TODO 所有代码都可以使用静态变量，只要根据范围控制符的规范，这个静态变量对其可见即可
    // >>TODO 比如public的静态变量，所有变量都可以使用它
    public static double DISCOUNT_FOR_VIP = 0.95;

    static double STATIC_VARIABLE_CURR_PACKAGE_ONLY = 100;

    // >>TODO 构造方法（constructor)的方法名必须与类名一样，而且构造方法没有返回值
    // >>TODO 构造方法可以有参数，规则和语法与普通方法一样。使用时，参数传递给new语句后的类名的括号里
    // >>TODO 如果没有显示地添加一个构造方法，JAVA会给每个类默认添加一个无参数的构造方法
    // >>TODO 如果我们自己添加了一个构造方法，JAVA就不会自带无参数的构造方法。这时候，就不能直接new一个无参数的对象
    // >>TODO 我们一直在使用构造方法，这也是为什么在创建对象时需要在类名后面有括号
    // >>TODO 构造方法不能用点操作符来调用或者在普通方法里调用，只能通过new语句在创建对象时使用
    // >>TODO 构造方法没有返回值，因为返回值没有意义，new语句创建出来的永远是对象的引用
    // >>TODO 如果构造方法是private的，那么只有当前类可以调用这个构造方法
    public Merchandise(String name, String id, int count, double soldPrice, double purchasePrice) {
        this.name = name;
        this.id = id;
        this.count = count;
        this.soldPrice = soldPrice;
        this.purchasePrice = purchasePrice;
    }

    // >>TODO 在构造方法里才能调用重载的构造方法，语法为this(参数列表）
    // >>TODO 构造方法不能自己调用自己，这会是一个死循环
    // >>TODO 调用重载的构造方法时，不能使用成员变量。因为用语意上讲，这个对象还没有被初始化完成，处于中间状态
    // >>TODO 在构造方法里调用重载的构造方法时，方法必须在代码的第一行，后面可以继续有代码
    public Merchandise(String name, String id, int count, double soldPrice) {
//        double purPrice = soldPrice * 0.8;
        this(name, id, count, soldPrice, soldPrice * 0.8);
//        double purPrice = soldPrice * 0.8;
    }

    // >>TODO 因为我们添加了构造方法后，JAVA就不会再添加无参数的构造方法。如果需要，我们可以自己添加这样的构造方法
    public Merchandise() {
        this("无名", "000", 0, 1.1, 1);
    }

    public static Merchandise createMerchandise(String name,String id,int count,double soldPrice,double purchasePrice){
        if(soldPrice < 0 || purchasePrice < 0){
            return  null;
        }

        return new Merchandise(name,id,count,soldPrice,purchasePrice);
    }
    // >>TODO 静态方法使用static修饰符
    // 静态方法的方法名没有约定全大写
    public static double getDiscountForVip() {
        // >>TODO 静态方法可以访问静态变量，包括自己类的静态变量和访问控制符允许范围内的其他类静态变量
        return DISCOUNT_FOR_VIP;
    }

    // >>TODO 除了没有this,静态方法的定义与成员方法一样，有方法名，参数和访问值
    // >>TODO 静态方法没有this自引用，不属于某个实例，调用时也不需要实例引用，直接用类名调用。因此它不能直接访问成员变量
    // >>TODO 当然静态方法里面，也可以自己创建对象，或者通过参数得到引用，进而调用方法和访问成员变量
    // >>TODO 静态变量只是没有this自引用方法而已
    public static double getDiscountOnDiscount(LittleSuperMarket littleSuperMarket) {
        double activityDiscount = littleSuperMarket.getActivityDiscount();
        return DISCOUNT_FOR_VIP * activityDiscount;
    }


    public void describe() {
        double netIncome = calculateProfit();
        System.out.println("商品名叫做" + name + ",id是" + id + "。商品售价是" + soldPrice
                + ",商品的进价为是" + purchasePrice + "。商品库存量是" + count + "。销售一个的毛利润是" + netIncome + "。VIP折扣为"
                + DISCOUNT_FOR_VIP);
    }

    public double calculateProfit() {
        double profit = soldPrice - purchasePrice;
        if (profit <= 0) {
            return 0;
        }

        return profit;
    }

    // >>TODO 返回值如果是基本类型，则要类型完全相同，或者符合类型自动转换规则
    public double getCurrentCount() {
        return count;
    }

    // >>TODO 如果不符合规则，可以使用强制类型转换
    public int getIntSoldPrice() {
        return (int) soldPrice;
    }

    public double buyDouble(double count) {
        System.out.println("buyDouble(double)被调用了");
        if (this.count < count) {
            return -1;
        }
        this.count -= count;
        double totalCost = count * soldPrice;
        return totalCost;
    }

    // 如果返回值是负数，就代表购买失败
    // TODO 论斤卖的商品，数量是double。我们把count成员变量改成double类型
    public double buy(double count) {
        System.out.println("buy(double)被调用了");
        if (this.count < count) {
            System.out.println("商品库存不足");
            return -1;
        }

//        System.out.println("商品单价为" + soldPrice);
//        int fullPriceCount = countToBuy / 2 + countToBuy % 2;
//        int halfPriceCount = countToBuy - fullPriceCount;
//        double totalCost = soldPrice * fullPriceCount + halfPriceCount * soldPrice / 2;

        this.count -= count;
        double totalCost = count * soldPrice;
        return totalCost;
    }

    public double buy() {
        System.out.println("buy()被调用了");
        return buy(1);
    }

    public double buy(int count) {
        System.out.println("buy(int)被调用了");
        return buy(count, false);
    }

    public double buy(int count, boolean isVIP) {
        System.out.println("buy(int,boolean)被调用了");
        if (this.count < count) {
            return -1;
        }
        this.count -= count;
        double totalCost = count * soldPrice;
        if (isVIP) {
            // >>TODO 静态方法的访问和静态变量一样，可以带上类名，当前类可以省略
            return totalCost * getDiscountForVip();
        }
        return totalCost;
    }


    public double buyAndPrintLeft(int countToBuy, boolean printLeft) {
        if (count < countToBuy) {
            System.out.println("商品库存不足");
            if (printLeft) {
                System.out.println("商品剩余库存为：" + count);
            }
            return -1;
        }

        System.out.println("商品单价为" + soldPrice);
        int fullPriceCount = countToBuy / 2 + countToBuy % 2;
        int halfPriceCount = countToBuy - fullPriceCount;
        double totalCost = soldPrice * fullPriceCount + halfPriceCount * soldPrice / 2;

        count -= countToBuy;
        if (printLeft) {
            System.out.println("商品剩余库存为：" + count);
        }

        return totalCost;
    }

    // >>TODO 参数可以是任何类型，包括自定义类型，甚至是自己的类型都没问题
    public boolean totalValueBiggerThan(Merchandise merchandise) {
        return count * purchasePrice > merchandise.purchasePrice * merchandise.count;
    }

    // >>TODO 参数可以是任何类型，包括自定义类型
    public boolean isTheBiggestTotalValueOne(LittleSuperMarket littleSuperMarket) {
        for (int i = 0; i < littleSuperMarket.getMerchandises().length; i++) {
            Merchandise m = littleSuperMarket.getMerchandises()[i];
            if (m != null) {
                if (m.purchasePrice * m.count > purchasePrice * count) {
                    return false;
                }
            }
        }
        return true;
    }

    // >> TODO hashCode 和 equals是我们最常覆盖的两个方法
    // >> TODO 覆盖的原则是，equals为true，hashCode就应该相等。这是一种约定俗成的规范
    // >> TODO 即equals为true是hashCode相等的充要条件，hashCode相等是equals为true的必要不充分条件
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Merchandise)) return false;
        Merchandise that = (Merchandise) o;
        return this.getCount() == that.getCount() &&
                Double.compare(that.getSoldPrice(), this.getSoldPrice()) == 0 &&
                Double.compare(that.getPurchasePrice(), this.getPurchasePrice()) == 0 &&
                getName().equals(that.getName()) &&
                getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getId(), getCount(), getSoldPrice(), getPurchasePrice());
    }

    @Override
    public String toString() {
        return "Merchandise{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", count=" + count +
                ", soldPrice=" + soldPrice +
                ", purchasePrice=" + purchasePrice +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getSoldPrice() {
        return soldPrice;
    }

    public void setSoldPrice(double soldPrice) {
        this.soldPrice = soldPrice;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
}
