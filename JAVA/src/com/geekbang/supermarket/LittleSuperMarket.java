package com.geekbang.supermarket;

public class LittleSuperMarket {
    private String superMarketName;
    private String address;
    private int parkingCount;
    private double inComingSum;
    private Merchandise[] merchandises;
    private int[] merchandiseSold;
    private double activityDiscount;

    public double getActivityDiscount() {
        return activityDiscount;
    }

    public void setActivityDiscount(double activityDiscount) {
        this.activityDiscount = activityDiscount;
    }

    /**
     * 初始化小超市
     *
     * @param superMarketName
     * @param address
     * @param parkingCount
     * @param merchandiseCount 商品种类数
     * @param count            每种商品缺省库存
     */
    public LittleSuperMarket(String superMarketName, String address, int parkingCount, int merchandiseCount, int count) {
        this.superMarketName = superMarketName;
        this.address = address;
        this.parkingCount = parkingCount;
        Merchandise giftForPhone = new Merchandise(
                "手机赠品-64G存储卡",
                "GIFT001",
                999,
                60,
                30
        );

        merchandises = new Merchandise[merchandiseCount];
        for (int i = 0; i < merchandises.length; i++) {
            // 创建手机，手机壳变色手机，和普通商品，都放在商品数组里
            Merchandise m = null;
            if (i > 0 & i % 100 == 0) {
                m = new ShellColorChangePhone(
                        "商品" + i,
                        "ID" + i,
                        count,
                        1999,
                        999,
                        4.5,
                        3.5,
                        4,
                        128,
                        "三星",
                        "Android",
                        giftForPhone
                );
            } else if (i > 0 & i % 10 == 0) {
                m = new Phone(
                        "商品" + i,
                        "ID" + i,
                        count,
                        1999,
                        999,
                        4.5,
                        3.5,
                        4,
                        128,
                        "索尼",
                        "Android",
                        giftForPhone

                );
            } else {
                double purchasePrice = Math.random() * 200;
                m = new Merchandise(
                        "商品" + i,
                        "ID" + i,
                        count,
                        1999,
                        999
                );
            }

            // 用创建的商品，给商品数组的第i个引用赋值，all和小超市的商品数组引用指向的是同一个数组对象
            merchandises[i] = m;
        }

        merchandiseSold = new int[merchandises.length];
        activityDiscount = 0.8;
    }

    public LittleSuperMarket() {
        this(null, null, 0, 0, 0);
    }

    public boolean findMerchandise(Merchandise target) {
        int i = 0;
        for (Merchandise m : merchandises) {
            boolean match = m.equals(target);
//            boolean match = (m == target);
            if (match) {
                System.out.println("找到了商品，位置在" + i);
                return true;
            }
            i++;
        }
        return false;
    }

    public String getSuperMarketName() {
        return superMarketName;
    }

    public void setSuperMarketName(String superMarketName) {
        this.superMarketName = superMarketName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getParkingCount() {
        return parkingCount;
    }

    public void setParkingCount(int parkingCount) {
        this.parkingCount = parkingCount;
    }

    public double getInComingSum() {
        return inComingSum;
    }

    public void setInComingSum(double inComingSum) {
        this.inComingSum = inComingSum;
    }

    public Merchandise[] getMerchandises() {
        return merchandises;
    }

    public void setMerchandises(Merchandise[] merchandises) {
        this.merchandises = merchandises;
    }

    public int[] getMerchandiseSold() {
        return merchandiseSold;
    }

    public void setMerchandiseSold(int[] merchandiseSold) {
        this.merchandiseSold = merchandiseSold;
    }

    // 一些特殊的逻辑

    /**
     * 获取毛利润最大的商品
     *
     * @return
     */
    public Merchandise getBiggestProfitMerchandise() {
        Merchandise curr = null;
        for (int i = 0; i < merchandises.length; i++) {
            Merchandise m = merchandises[i];
            if (curr == null) {
                curr = m;
                continue;
            }
            if (m.calculateProfit() > curr.calculateProfit()) {
                curr = m;
            }
        }
        return curr;
    }

    /**
     * 根据索引获取商品
     *
     * @param merchandiseIndex
     * @return
     */
    public Merchandise getMerchandiseOf(int merchandiseIndex) {
        if (merchandiseIndex < 0 || merchandiseIndex >= merchandises.length) {
            return null;
        }

        return merchandises[merchandiseIndex];
    }

    /**
     * 赚钱
     *
     * @param toBeAdd
     */
    public void addIncomingSum(double toBeAdd) {
        inComingSum += toBeAdd;
    }

    /**
     * 花钱
     *
     * @param toBeSpent
     */
    public boolean spendMoney(double toBeSpent) {
        if (toBeSpent > inComingSum) {
            return false;
        }
        inComingSum -= toBeSpent;
        return true;
    }


}
