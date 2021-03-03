package com.geekbang.myself.learnThread;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.concurrent.Task;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：wujun
 * @date ：Created in 2021/1/18
 * @description：了解 wait()、notify()、notifyAll()函数的使用
 */
public class WaitAndNotfiy {

    public static void main(String[] args) throws InterruptedException {
//        Object object = new Object();
//        System.out.println("main线程----------start");
//        Thread myThread = new Thread(() -> {
//
//            System.out.println("这是我创建的线程------start");
//            synchronized (object) {
//                System.out.println("myThread线程获得object的锁");
//                try {
//                    Thread.sleep(10000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
////                System.out.println("调用object的wait()方法");
////                try {
////                    object.wait();
////                } catch (InterruptedException e) {
////                    e.printStackTrace();
////                }
//                object.notify(); //唤醒在等待object锁的线程
//                System.out.println("myThread-唤醒在等待object锁的线程");
//            }
//
//            System.out.println("这是我创建的线程------end");
//        });
//
//
//        myThread.start();
////        myThread.join();    // join()方法是让myThread线程执行完成之后，主线程才能够继续执行
////        object.toString();
////        Thread.sleep(1000);    //让当前线程睡一会儿
//        System.out.println("main线程准备进入同步代码块");
//        synchronized (object) {
//            System.out.println("main线程获得锁");
//            System.out.println("main线程释放锁");
//            object.wait();    //在此处将object锁释放，main线程进入waiting状态，需要被notify()唤醒
//            Thread.sleep(10000);
//            System.out.println("main线程----------end");
//        }


        TaskQueue queue = new TaskQueue();
        List<Thread> ts = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(() -> {
                while (true) {
                    try {
                        String task = queue.getTask();
                        System.out.println("execute task" + task);
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            });
            t.start();
            ts.add(t);
        }

        Thread add = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                String task = "t-" + i;
                System.out.println("add task" + task);
                queue.addTask(task);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        add.start();
        add.join();
        Thread.sleep(100);
        for (Thread t : ts) {
            t.interrupt();
        }

    }
}

// 任务队列
class TaskQueue {
    Queue<String> queue = new LinkedList<>();

    public synchronized void addTask(String s) {
        queue.add(s);
        this.notifyAll();
    }

    public synchronized String getTask() throws InterruptedException {
        while (queue.isEmpty()) {   //如果任务为空，就循环等待
            this.wait();
        }
        return queue.remove();
    }
}
