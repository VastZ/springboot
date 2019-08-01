package com.boot.test;

public class SyncTest {

    public static volatile int count = 0;

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 5; i++) {
            Thread a = new Thread(() -> {
                for (int j = 0; j < 2; j++) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    count++;
                    System.out.println(count);
                }
            });
            a.start();
            a.join();
        }

    }

}
