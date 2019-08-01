package com.boot.learn.math;

import java.util.Collections;
import java.util.HashMap;

public class MathDemo {

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(Math.log10(100000000d));
        Collections.synchronizedMap(new HashMap<>());
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return super.loadClass(name);
            }
        };
        Class<?> listTest = classLoader.loadClass("com.boot.learn.interview.ListTest");

        System.out.println(listTest);
    }

}
