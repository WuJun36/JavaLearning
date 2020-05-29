package com.producerconsumer;

import java.util.Queue;

public class Producer<T> {
    private Queue<T> tasks;
    private int maxTaskCount = 0;

    public Producer(Queue<T> tasks, int maxTaskCount) {
        this.tasks = tasks;
        this.maxTaskCount = maxTaskCount;
    }
}
