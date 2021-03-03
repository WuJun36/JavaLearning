package com.geekbang.myself.learnThread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author ：wujun
 * @date ：Created in 2021/2/2
 * @description：使用ReadWriteLock
 */
public class ReadWriteLockAppMain {

    public static void main(String[] args) {
        // TODO ReadWriteLock适合读多写少的场景
        Counter3 counter = new Counter3();
        List<Thread> readList = new ArrayList<>();

        Thread write = new Thread(()->{
            counter.inc(1);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        for (int i = 0; i < 5; i++) {
            Thread read = new Thread(()->{
               System.out.println();
               Arrays.stream(counter.get()).forEach(System.out::print);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            readList.add(read);
        }

        write.start();
        readList.get(1).start();
        readList.get(0).start();

    }

}

class Counter3{
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock writeLock = lock.writeLock();  // TODO 写锁
    private final Lock readLock = lock.readLock();    // TODO 读锁
    private int[] count = new int[10];

    public void inc(int index){
        writeLock.lock();   //TODO 当线程获得写锁后，其他线程则不能获取写锁和读锁，即只允许一个线程写入，此时不能读取
        try {
            count[index] += 1;
        }finally {
            writeLock.unlock();
        }
    }

    public int[] get(){
        readLock.lock();    //TODO 当没有写入线程，只有读取线程时，多个读取线程可以同时进行
        try{
            return Arrays.copyOf(count,count.length);
        }finally {
            readLock.unlock();
        }
    }
}
