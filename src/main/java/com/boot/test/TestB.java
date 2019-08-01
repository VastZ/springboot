package com.boot.test;

/**
 * @author zhang.wenhan
 * @description TestB
 * @date 2019/7/15 13:16
 */
public class TestB {

    public static void test(String str) {
        String s = str + "a" + "b" + "c";
    }

    public static void test1(String a, String b, String c, String d) {
        String s1 = a + b;
        String s2 = c + d;
    }

    public static void test2(String str) {
        String a = "a";
        String b = "b";
        String c = "c";
        String d = "d";
        String s = a + b;
        String s1 = c + d;
        String s2 = s + s1;
    }

}
