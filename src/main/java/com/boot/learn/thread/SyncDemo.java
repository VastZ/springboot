package com.boot.learn.thread;

public class SyncDemo {

    public static void main(String[] args) {
        final MyServiec myServiec = new MyServiec();
        final MyServiec myServiec2 = new MyServiec();

        new Thread(() -> {
            try {
                System.out.println("A线程开始执行");
                myServiec.methodA();
                myServiec.methodB();
                System.out.println("A线程执行完");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();

        new Thread(() -> {
            try {
                System.out.println("B线程开始执行");
                myServiec2.methodB();
                myServiec2.methodA();
                System.out.println("B线程执行完");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();

    }

}

class MyServiec{

    public synchronized  void methodA() throws InterruptedException {
        System.out.println("当前线程" + Thread.currentThread().getName() + " 执行方法A");
        Thread.sleep(2000);
    }

    public synchronized  void methodB() throws InterruptedException {
        System.out.println("当前线程" + Thread.currentThread().getName() + " 执行方法B");
        Thread.sleep(3000);
    }


}
