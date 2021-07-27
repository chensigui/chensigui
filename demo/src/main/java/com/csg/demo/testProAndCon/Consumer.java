package com.csg.demo.testProAndCon;

import lombok.SneakyThrows;

import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread {

    public BlockingQueue blockingQueue;

    public Consumer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @SneakyThrows
    @Override
    public void run() {
        consume();
    }

    public void consume() throws InterruptedException {
        System.out.println("----消费者开始消费消息---");
        int take = (int) blockingQueue.take();
        System.out.println("----消费者消费的消息是" + take);
    }

}
