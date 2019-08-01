package com.boot.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhang.wenhan
 * @description TestEs
 * @date 2019/7/16 15:44
 */
public class TestEs {
    public static ExecutorService es = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        for (final String str : list) {
            es.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        test(str);
                        System.out.println(Thread.currentThread().getName() + ":" + str);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            });
        }
        es.shutdown();
    }

    public static void test(String str) {
        try {
            if ("c".equals(str)) {
                String a = null;
                a.equals(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
