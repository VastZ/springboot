package com.boot.test;

/**
 * @author zhang.wenhan
 * @description StringArrayTest
 * @date 2019/7/11 10:48
 */
public class StringArrayTest {

    public static void main(String[] args) {
        StaticTest t = new StaticTest();
        System.out.println(t.str);

    }

}

class StaticTest{
    public static String str ;
     {
        str = "123";
        System.out.println("类" + str);
    }

}