package com.geekbang.myself.learnThread;

/**
 * @author ：wujun
 * @date ：Created in 2021/1/20
 * @description：中断线程
 */
public class InterruptThread {

    public static void main(String[] args) throws InterruptedException {

        Thread t = new MyThread2();
        t.start();
        Thread.sleep(1000);   // main线程进入sleep状态，t线程继续运行
        t.interrupt();  // 对t线程发出中断请求
        t.join();       // main线程需要等到t线程运行结束
        System.out.println("end");


        HelloThread hello1 = new HelloThread();
        HelloThread hello2 = new HelloThread();
        hello1.start();
        Thread.sleep(1000);
//        hello2.start();
        // 其实这种操作相当于在主线程中修改hello线程的实例变量，修改hello变量的过程是在主线程中进行的，所以running标志位属于线程间的共享变量
        hello1.running = false;
        System.out.println(Thread.currentThread().getName() + " hello1的running标志为=" + hello1.running);
//        System.out.println("hello2的running标志位=" + hello2.running);

    }
}

class MyThread2 extends Thread {

    @Override
    public void run() {
        Thread hello = new HelloThread();
        hello.start();
        try {
            // 当前线程正处于等待状态，接收到中断请求后，hello.join()方法会立刻结束，并抛出InterruptedException
            // 但是hello线程还是会继续执行，不受影响，只是当前线程会结束当前等待状态，往下执行
            hello.join();
        } catch (InterruptedException e) {
            System.out.println("hello is interrupted");
        }
        System.out.println("hello.join()中断");
//        hello.interrupt();  // todo 只是发出中断的请求，hello线程是否会响应需要看程序的设计
    }
}

class HelloThread extends Thread {

    public volatile boolean running = true;  //线程间的共享变量需要使用volatile关键字标记，确保每个线程都能读取到更新后的变量值

    @Override
    public void run() {
        int n = 0;
        while (!isInterrupted() && running) {   // todo 循环判断当前线程是否被中断，否则无法正确响应interrupt()
            n++;
            System.out.println(n + "次hello");
            System.out.println(currentThread().getName() + " running标志位=" + running);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
        System.out.println(currentThread().getName() + "running标志位=" + running);
    }
}
