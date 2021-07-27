package com.csg.demo.testProAndCon;

import lombok.SneakyThrows;

import java.util.concurrent.BlockingQueue;

public class Producer extends Thread {

    public BlockingQueue blockingQueue;

    public Producer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @SneakyThrows
    @Override
    public void run() {
        produce();
    }

    public void produce() throws InterruptedException {
        System.out.println("----生产者开始生产消息---");
        blockingQueue.put(1);
        System.out.println("----生产者生产好了消息---");
    }

}
