package com.boot.learn.thread;

public class SynchronizedDemo {

    public static void main(String[] args) {

        testClass(); // C D 只有当一个执行完 才开始 锁对应 class   this和class不是同一个对象，所以可以分别进入
        testThis(); // A B 同时开始 锁对应实例 如果是同一个实例则会排队按顺序进行
//        testStatic();// E F 只有当一个执行完 才开始 锁对应 class 与 testClass 共享一个锁
//        testMethod(); // G H 同时开始 锁对应实例
    }


    static void testThis(){
        MySync mySync = new MySync();
        new Thread(() -> {
//            MySync mySync = new MySync();
            try {
                mySync.syncThis();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();
        new Thread(() -> {
//            MySync mySync = new MySync();
            try {
                mySync.syncThis();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();
    }

    static void testClass(){
        new Thread(() -> {
            MySync mySync = new MySync();
            try {
                mySync.syncClass();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "C").start();
        new Thread(() -> {
            MySync mySync = new MySync();
            try {
                mySync.syncClass();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "D").start();
    }

    static void testStatic(){
        new Thread(() -> {
            try {
                MySync.syncStaticMothed();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "E").start();
        new Thread(() -> {
            try {
                MySync.syncStaticMothed();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "F").start();
    }
    static void testMethod(){
        new Thread(() -> {
            MySync mySync = new MySync();
            try {
                mySync.syncMothed();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "G").start();
        new Thread(() -> {
            MySync mySync = new MySync();
            try {
                mySync.syncMothed();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "H").start();
    }

    static class MySync {

        public void syncThis() throws InterruptedException {
            synchronized (this) {
                System.out.println(Thread.currentThread().getName() + "正在执行");
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + "执行完毕");
            }
        }

        public void syncClass() throws InterruptedException {
            synchronized (MySync.class) {
                System.out.println(Thread.currentThread().getName() + "正在执行");
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + "执行完毕");
            }
        }

        public synchronized void syncMothed() throws InterruptedException {
            System.out.println(Thread.currentThread().getName() + "正在执行");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + "执行完毕");
        }

        public static synchronized void syncStaticMothed() throws InterruptedException {
            System.out.println(Thread.currentThread().getName() + "正在执行");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + "执行完毕");
        }

    }


}