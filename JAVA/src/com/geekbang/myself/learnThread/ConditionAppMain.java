package com.geekbang.myself.learnThread;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：wujun
 * @date ：Created in 2021/2/2
 * @description：使用condition来进行线程的等待和唤醒操作
 */
public class ConditionAppMain {
    public static void main(String[] args) throws InterruptedException {

        TaskQueue2 queue = new TaskQueue2();
        List<Thread> list = new ArrayList<>();


        for (int i = 0; i < 2; i++) {
            Thread consume = new Thread(() -> {
                try {
                    while (true) {
                        String s = queue.getQueue();
                        System.out.println("execute " + s);
                    }
                } catch (InterruptedException e) {
                    return;
                }
            });
            consume.start();
            list.add(consume);
        }


        Thread produce = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                String s = "task" + i;
                System.out.println("add " + s);
                queue.addQueue(s);
            }
        });

        produce.start();
        Thread.sleep(1000);
        for (Thread t : list) {
            t.interrupt();
        }

    }
}

class TaskQueue2 {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();   //TODO 必须调用lock的newCondition()方法
    private final Queue<String> queue = new LinkedList<>();

    public void addQueue(String s) {
        lock.lock();
        try {
            queue.add(s);
            condition.signalAll();       //TODO 相当于notifyAll()方法
        } finally {
            lock.unlock();
        }
    }

    public String getQueue() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                condition.await();   //TODO 相当于wait()方法
            }
            return queue.remove();
        } finally {
            lock.unlock();
        }
    }
}
