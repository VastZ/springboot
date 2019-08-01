package com.boot.learn.thread;

/**
 * @author zhang.wenhan
 * @description TestThread
 * @date 2019/5/14 10:34
 */
public class TestThread {

    public static void main(String[] args) throws InterruptedException {
        MyThread m = new MyThread();
        m.setName("A");
        Thread t = new Thread(m, "B");
        t.start();

    }

}

class MyThread extends Thread{
    public MyThread(){
        System.out.println("构造方法开始初始化-----");
        System.out.println("构造方法当前线程：" + Thread.currentThread().getName());
        System.out.println("构造方法当前线程名称" + this.getName());
        System.out.println("构造方法当前线程ID" + Thread.currentThread().getId());
        System.out.println("构造方法开始初始化-----结束");
    }

    @Override
    public void run() {
        System.out.println("run 开始初始化-----");
        System.out.println("run 当前线程：" + Thread.currentThread().getName());
        System.out.println("run 当前线程名称" + this.getName());
        System.out.println("run 当前线程ID" + Thread.currentThread().getId());
        System.out.println("run 开始初始化-----结束");
    }
}