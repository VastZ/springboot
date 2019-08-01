package com.boot.dayask;

/**
 * @author zhang.wenhan
 * @description MathTest
 * @date 2019/7/16 10:19
 */
public class LongDivision {

    private static final long MILLIS_PER_DAY
            = 24 * 60 * 60 * 1000;

    private static final long MICROS_PER_DAY
            = 24 * 60 * 60 * 1000 * 1000;

    private static final long MICROS_PER_DAY_2
            = 24L * 60 * 60 * 1000 * 1000;

    public static void main(String[] args) {
        System.out.println(MICROS_PER_DAY);
        System.out.println(MILLIS_PER_DAY);
        System.out.println(MICROS_PER_DAY_2);
        System.out.println(Integer.MAX_VALUE);
        long max = 2147483648L * 2;
        long a = 86400000000L - 500654080;
        System.out.println(max);
        System.out.println(a);
        System.out.println(max * 20);
        System.out.println(a / max);
        System.out.println(MICROS_PER_DAY / MILLIS_PER_DAY);
    }
}
