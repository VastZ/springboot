package com.boot.learn.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo2 {

    public static void main(String[] args) {
        final Lock lock = new ReentrantLock();
        lock.newCondition();
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(1);
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

    }

}
