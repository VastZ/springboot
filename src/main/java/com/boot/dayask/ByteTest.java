package com.boot.dayask;

/**
 * @author zhang.wenhan
 * @description ByteTest
 * @date 2019/8/2 11:14
 */
public class ByteTest {

    public static void add(Byte b){
        b = b++;
//        System.out.println( "add: " + b);
    }

    public static void main(String[] args) {
        Byte a = 127;
        Byte b = 127;
        add(++a);
        System.out.println(a + ""); // -128
        add(b);
        System.out.println(b + ""); // 127

    }


}
