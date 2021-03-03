package com.geekbang.myself.learnThread;

/**
 * @author ：wujun
 * @date ：Created in 2021/1/28
 * @description：学会使用synchronized
 */
public class SynchronizedAppMain {

    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
//        Thread addThread = new AddThread();
//        Thread minusThread = new MinusThread();
//
//        addThread.start();
//        minusThread.start();
//        addThread.join();
//        minusThread.join();
//        System.out.println(Counter.count);
//
//        Counter counter = new Counter();
//        Thread addThread2 = new Thread(() -> {
//            for (int i = 0; i < 1000; i++) {
//                counter.add();
//            }
//        });
//
//        Thread minusThread2 = new Thread(() -> {
//            for (int i = 0; i < 1000; i++) {
//                counter.minus();
//            }
//        });
//
//        addThread2.start();
//        minusThread2.start();
//        addThread2.join();
//        minusThread2.join();
//        System.out.println("---------------");
//        System.out.println(counter.anotherCount);


        System.out.println("========死锁=======");
        Object A = new Object();
        Object B = new Object();
        Thread threadA = new Thread(()->{
            synchronized (A){
                System.out.println(Thread.currentThread().getName()+"获取到A锁");
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName()+"正在在处理");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"尝试获取B锁");
                synchronized (B){
                    System.out.println(Thread.currentThread().getName()+"获取到B锁");
                }
            }
        });

        Thread threadB= new Thread(()->{
            synchronized (B){
                System.out.println(Thread.currentThread().getName()+"获取到B锁");
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName()+"正在在处理");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"尝试获取A锁");
                synchronized (A){
                    System.out.println(Thread.currentThread().getName()+"获取到A锁");
                }
            }
        });

        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();
        // TODO 以上情况便会造成死锁，因为A线程试图获取锁B，
        // TODO 而锁B已被B线程获取，B线程只有在获取到锁A之后，才会继续往下执行，从而释放锁B
        // TODO 但是线程A只有拿到锁B，执行完程序后才会释放锁A
        // TODO 因此两个线程都会进入一直等待的状态
        System.out.println("main线程结束");


    }

}

class Counter {
    public static Object lock = new Object();
    public static int count = 0;
    public int anotherCount = 0;

    public synchronized  void add() {
        anotherCount++;
    }

    public synchronized  void minus() {
        anotherCount--;
    }

}

class MinusThread extends Thread {

    @Override
    public void run() {
        //synchronized必须作用在对象或者类上，不能是基本数据类型
        synchronized (SynchronizedAppMain.lock) {
            for (int i = 0; i < 10000; i++) {
                Counter.count--;
            }
        }

    }
}

class AddThread extends Thread {
    @Override
    public void run() {
        synchronized (SynchronizedAppMain.lock) {
            for (int i = 0; i < 10000; i++) {
                Counter.count++;
            }
        }
    }
}
