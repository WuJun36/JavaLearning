package com.geekbang.supermarket;

public class ShellColorChangePhone extends Phone {
    public boolean enableShellColorChange;

    public ShellColorChangePhone(String name, String id, int count, double soldPrice, double purchasePrice,
                                 double screenSize, double cpuHZ, int memoryG, int storageG, String brand, String os,Merchandise gift) {
        super(name, id, count, soldPrice, purchasePrice, screenSize, cpuHZ, memoryG, storageG, brand, os,gift);
        enableShellColorChange = false;
    }

    public boolean isEnableShellColorChange() {
        return enableShellColorChange;
    }

    public void setEnableShellColorChange(boolean enableShellColorChange) {
        this.enableShellColorChange = enableShellColorChange;
    }

    @Override
    public void describe() {
        super.describe();
        System.out.println("壳色随着屏幕色变的功能开启状态：" + enableShellColorChange);
    }

    @Override
    public double calculateProfit() {
        // 厂家提供十个点的返点
        return super.calculateProfit() + super.getPurchasePrice() * 0.1;
    }

    @Override
    public double buy(int count) {
        System.out.println("ShellColorChangePhone里的buy(int count)");
        if (count < 2) {
            System.out.println("买一送一了解一下，不单卖哦！");
            return -1;
        }
        return super.buy(count);
    }

    public static void staticNoOverride(){
        System.out.println("staticNoOverride in ShellColorChangePhone");
    }
}
