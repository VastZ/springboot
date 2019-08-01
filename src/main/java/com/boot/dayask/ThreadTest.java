package com.boot.dayask;

import junit.framework.TestCase;

/**
 * @author zhang.wenhan
 * @description ThreadTest
 * @date 2019/8/1 15:04
 */
public class ThreadTest extends TestCase {

    int number;

    public void test() throws InterruptedException {
        number = 0;
        Thread t = new Thread(() -> {
            try {
                assertEquals(2, number);
            } catch (Error e){

            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        number = 1;
        t.start();
        number++;
        t.join();
    }

}
