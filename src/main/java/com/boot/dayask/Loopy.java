package com.boot.dayask;

/**
 * @author zhang.wenhan
 * @description a
 * @date 2019/7/17 10:35
 */
public class Loopy {
    public static void main(String[] args) {
        final int start = Integer.MAX_VALUE - 100;
        final int end = Integer.MAX_VALUE;
        int count = 0;
        // Condition i <= end is always true;
        for (int i = start; i <= end; i++)
            count++;
        System.out.println(count);
    }
}
