package com.boot.dayask;

/**
 * @author zhang.wenhan
 * @description a
 * @date 2019/7/19 13:12
 */
public class Lazy {
    private static boolean initialized = false;
    static {
        Thread t = new Thread(() -> initialized = true);
        t.start();
        try {
            System.out.println("2");
            t.join();
        } catch (InterruptedException e) {
            throw new AssertionError(e);
        }
    }
    public static void main(String[] args) {
        System.out.println("3");
        System.out.println(initialized);
    }
}