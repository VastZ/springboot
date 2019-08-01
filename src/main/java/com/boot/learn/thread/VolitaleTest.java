package com.boot.learn.thread;

/**
 * @author zhang.wenhan
 * @description VolitaleTest
 * @date 2019/7/15 9:41
 */
public class VolitaleTest {

    public static volatile int count = 0;

    public static void main(String[] args) {
       for(int i =0; i < 5000; i++){
           new Thread(()-> count++).start();
       }
        System.out.println(count);
    }

}
