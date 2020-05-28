package com.waitnotify;

import java.util.concurrent.TimeUnit;

public class ThreadWaitNotify {
    public static void main(String[] args) {
        Object locker = new Object();

        int workingSec = 2;
        int threadCount = 5;
        for (int i = 0; i < threadCount; i++) {
            new Thread(() -> {
                System.out.println(getName() + ":线程开始工作");

                try {
                    synchronized (locker) {
                        sleepSec(workingSec);
                        System.out.println(getName() + "：进入等待");
                        locker.wait();
                        System.out.println(getName() + "：线程继续...");
                        sleepSec(2);
                        System.out.println(getName() + "：结束");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }, "工作线程" + i).start();
        }
        System.out.println("--------------唤醒线程开始sleep------------------");
        sleepSec(workingSec + 1);
        System.out.println("--------------唤醒线程sleep结束------------------");
        synchronized (locker){
            for (int i =0;i<threadCount;i++){
                System.out.println("----------------开始逐个唤醒----------------------");
                locker.notify();
            }
        }

    }

    private static void sleepSec(int sec) {
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(sec));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static String getName() {
        return Thread.currentThread().getName();
    }
}
