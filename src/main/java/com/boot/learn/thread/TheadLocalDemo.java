package com.boot.learn.thread;

import java.util.TimerTask;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TheadLocalDemo {


    public static void main(String[] args) {

        ThreadLocalUtil.setThreadLocal("Test","Hello,World");
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new TimerTask() {
            @Override
            public void run() {
                System.out.println("结束");
            }
        });

        Thread t1 = new User("小明", cyclicBarrier);
        Thread t2 = new User("小红", cyclicBarrier);
        Thread t3 = new User("小白", cyclicBarrier);
        t1.start();
        t2.start();
        t3.start();

    }

}

class User extends Thread{

    private String word;
    private CyclicBarrier cyclicBarrier;

    public User(String word, CyclicBarrier cyclicBarrier){
        this.word = word;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        ThreadLocalUtil.setThreadLocal("myKey",word);
        System.out.println(Thread.currentThread().getName() + "--" + ThreadLocalUtil.getThreadLocal("myKey"));

    }
}
