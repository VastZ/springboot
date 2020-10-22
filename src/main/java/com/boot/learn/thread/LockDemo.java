package com.boot.learn.thread;

import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

    public static void main(String[] args) throws InterruptedException {
        final int[] count = {0};
        ReentrantLock lock = new ReentrantLock();
        for(int i =0; i<50; i++){
            new Thread(() -> {
                lock.lock();
                try{
                    int a = count[0];
                    count[0] = a + 1;
                } finally {
                    lock.unlock();
                }
            }).start();
        }
        System.out.println(count[0]);
    }

}
