package learnthread;

import sun.net.idn.StringPrep;

public class MultiThreadChaos {
    public static void main(String[] args) {
        DataHolder dataHolder = new DataHolder();
        Thread increase = new Thread(new ChangeData(2, Integer.MAX_VALUE / 50, dataHolder));
        Thread decrease = new Thread(new ChangeData(-2, Integer.MAX_VALUE / 50, dataHolder));
        System.out.println("执行开始");
        increase.start();
        decrease.start();
        System.out.println("执行结束");
    }
}
