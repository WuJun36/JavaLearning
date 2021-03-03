package com.geekbang.myself.learnThread;

/**
 * @author ：wujun
 * @date ：Created in 2021/1/19
 * @description：线程的创建方式
 */
public class CreateNewThread {
    public static void main(String[] args) {
        // TODO 方法一： 从Thread派生一个自定义类，重写run()方法
        Thread thread1 = new MyThread("MyThread1");
        thread1.start();   // 线程开始执行要用start()方法，start()方法内部会调用run()方法，run()方法执行完毕，线程结束。
        thread1.run();     // 虽然run()方法会执行，但是在main线程来执行，并不是在thread线程中执行

        // TODO 方法二：创建线程实例时，传入一个Runnable实例
        Thread thread2 = new Thread(new MyRunnable(), "MyThread2");
        thread2.start();

        // TODO 方法三：用lambda语法简化方法二
        Thread thread3 = new Thread(() -> {
            Thread thread = Thread.currentThread();
            System.out.println("当前执行线程为：" + thread.getName());
            System.out.println("通过继承Thread，重写run()方法创建线程--start");
            System.out.println("通过继承Thread，重写run()方法创建线程--end");
        },"MyThread3");
        thread3.start();

    }
}

class MyThread extends Thread {

    MyThread(String threadName) {
        super(threadName);
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println("当前执行线程为：" + thread.getName());
        System.out.println("通过继承Thread，重写run()方法创建线程--start");
        System.out.println("通过继承Thread，重写run()方法创建线程--end");
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println("当前执行线程为：" + thread.getName());
        System.out.println("通过传入Runnable实例来创建线程--start");
        System.out.println("通过传入Runnable实例来创建线程--end");

    }
}

