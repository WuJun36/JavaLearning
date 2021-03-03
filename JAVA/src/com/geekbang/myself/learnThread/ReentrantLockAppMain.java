package com.geekbang.myself.learnThread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：wujun
 * @date ：Created in 2021/2/1
 * @description：ReentrantLock的使用
 */
public class ReentrantLockAppMain {

    public static void main(String[] args) throws InterruptedException {
        Counter2 counter = new Counter2();
        Thread add = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                try {
                    counter.add(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        Thread minus = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                try {
                    counter.minus(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        add.start();
        minus.start();
        add.join();
        minus.join();
        System.out.println(counter.getCount());
    }

}

class Counter2{
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private int count;

    public void add(int n) throws InterruptedException {
        lock.lock();          //TODO 获取锁
        try{
            count += n;
            Thread.sleep(2000);
        }finally {
            lock.unlock();        //释放锁
        }
    }

    public void minus(int n) throws InterruptedException {

        if (lock.tryLock(1, TimeUnit.SECONDS)){
            try{
                count -= n;
            }finally {
                lock.unlock();
            }
        }else {
            System.out.println("minus等了1秒仍没有获得锁，不再等待，开始其他的工作");
        }

    }

    public int getCount(){
        return count;
    }

}
