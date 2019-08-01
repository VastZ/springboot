package com.boot.learn.thread;

/**
 * @author zhang.wenhan
 * @description JoinTest
 * @date 2019/7/19 16:30
 */
public class JoinTest {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> System.out.println("t1 ") );
        Thread t2 = new Thread(() -> System.out.println("t2 ") );
        Thread t3 = new Thread(() -> System.out.println("t3 ") );
        Thread t4 = new Thread(() -> System.out.println("t4 ") );

        try {
            t1.start();
            t1.join();
            t2.start();
            t2.join();
            t3.start();
            t3.join();
            t4.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
