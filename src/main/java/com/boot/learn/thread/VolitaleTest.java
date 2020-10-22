package com.boot.learn.thread;

/**
 * @author zhang.wenhan
 * @description VolitaleTest
 * @date 2019/7/15 9:41
 */
public class VolitaleTest {

    public static volatile int count = 0;

    public static void main(String[] args) throws InterruptedException {
       for(int i =0; i < 50000; i++){
           new Thread(()-> count++).start();
       }
       Thread.sleep(4000);
        System.out.println(count);
    }

}
