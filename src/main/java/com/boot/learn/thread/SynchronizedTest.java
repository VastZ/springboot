package com.boot.learn.thread;

/**
 * @author zhang.wenhan
 * @description SynchronizedTest
 * @date 2019/7/15 14:51
 */
public class SynchronizedTest {

    public static void main(String[] args) {
        ThreadDemo t = new ThreadDemo();
        new Thread(() -> {
            try {
                t.syncThis();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                t.syncClass();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

}

class ThreadDemo {
    public void syncThis() throws InterruptedException {
        synchronized (ThreadDemo.class){
            System.out.println(Thread.currentThread().getName() + " this 开始执行");
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + " this 执行结束了~~~~");
        }
    }

    public void syncClass() throws InterruptedException {
        synchronized (ThreadDemo.class){
            System.out.println(Thread.currentThread().getName() + " Class 开始执行");
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + " Class 执行结束了~~~~");
        }
    }

}
