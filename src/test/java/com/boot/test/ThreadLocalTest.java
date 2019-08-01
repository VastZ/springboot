package com.boot.test;

public class ThreadLocalTest {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {

        new Thread(()->{
            threadLocal.set("1234567");
            System.out.println(threadLocal.get());
        }).start() ;

        new Thread(()->{
            threadLocal.set("54321");
            System.out.println(threadLocal.get());
        }) .start();
        System.out.println(threadLocal.get());
    }

}
