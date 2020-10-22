package com.boot.learn.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * @author zhang.wenhan
 * @description CountDownLunchDemo
 * @date 2019/8/20 11:10
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        test();
    }

    public static void test() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++){
            new Thread(() ->{
                System.out.println(Thread.currentThread().getName() + "我要减1");
                countDownLatch.countDown();
            }).start();
        }
        // 等待countDownLatch 减少至0时再进行下一步
        countDownLatch.await();
        System.out.println("循环完毕");

        Semaphore semaphore = new Semaphore(1);



    }

}
