package com.boot.dayask;

/**
 * @author zhang.wenhan
 * @description HelloSogou
 * @date 2019/8/2 13:20
 */
public class HelloSogou {

    public static synchronized void main(String[] a) {
        Thread t = new Thread(() -> Sogou());
        t.run();
//        t.start();
        System.out.print("Hello");
    }

    static synchronized void Sogou() {
        System.out.print("Sogou");
    }
}

