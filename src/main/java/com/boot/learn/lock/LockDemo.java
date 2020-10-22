package com.boot.learn.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhang.wenhan
 * @description LockDemo
 * @date 2019/12/10 13:35
 */
public class LockDemo {


    public static int m = 0;

    public static void test() throws InterruptedException {
        final int[] n = {0};
        for(int i = 0; i < 5000 ; i++){
            new Thread(() ->{
                try {
                    Thread.sleep(20);
                    n[0] ++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        Thread.sleep(5000);
        System.out.println("test 不加锁: " + n[0]);
    }

    public static void testLock() throws InterruptedException {
        Lock lock = new ReentrantLock();
        for(int i = 0; i < 5000 ; i++){
            new Thread(() ->{
                try{
                    lock.lock();
                    Thread.sleep(20);
                    m++;
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            } ).start();
        }

    }


    public static void main(String[] args) throws InterruptedException {
        test();
        testLock();
    }

}
