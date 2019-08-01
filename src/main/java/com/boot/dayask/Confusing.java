package com.boot.dayask;

/**
 * @author zhang.wenhan
 * @description a
 * @date 2019/7/17 10:27
 */
public class Confusing {
    public Confusing(Object o) {
        System.out.println("Object");
    }
    public Confusing(double[] dArray) {
        System.out.println("double array");
    }
    public static void main(String args[]) {
        new Confusing(null);
    }
}