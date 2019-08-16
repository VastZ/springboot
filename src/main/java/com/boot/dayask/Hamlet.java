package com.boot.dayask;

import java.util.Random;

/**
 * @author zhang.wenhan
 * @description a
 * @date 2019/8/13 14:37
 */
public class Hamlet {
    public static void main(String[] args) {
        Random rnd = new Random();
        boolean toBe = rnd.nextBoolean();
        Number result = (toBe || !toBe) ? new Integer(3) : new Float(1);
        System.out.println(result);

        String str = "GroupOrderMainFrom";
        System.out.println(str.substring(str.length() - 10));
    }
}
