package com.boot.learn.thread;

/**
 * @author zhang.wenhan
 * @description TestThread2
 * @date 2019/5/14 15:29
 */
public class TestThread2 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                System.out.println("进入线程");
                for(int i = 0; i< 5000; i ++){
//                    if(Thread.currentThread().isInterrupted()){
//                        break;
//                    }
                    System.out.println("i = " + i);
                }
                Thread.sleep(10000);
                System.out.println("for 下面");
            } catch (Exception e) {
                System.out.println("进入异常");
                e.printStackTrace();
            }
            System.out.println("线程执行完毕");
        });
        thread.start();
//        thread.stop();
        Thread.sleep(1000);
        thread.interrupt();
    }

}
