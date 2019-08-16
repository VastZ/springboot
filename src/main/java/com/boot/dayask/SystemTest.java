package com.boot.dayask;

import java.io.PrintStream;

/**
 * @author zhang.wenhan
 * @description SystemTest
 * @date 2019/8/13 14:47
 */
public class SystemTest {
    public static void main(String[] args) {
        int a = 10;
        int b = 10;
        // 下面方法调用后只打印出a=100,b=200
        method(a, b);
        method1(a, b);
        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }

    public static void method1(Integer a, Integer b) {
        System.out.println("a=100");
        System.out.println("b=200");
        System.exit(0);
    }

    public static void method(Integer a, Integer b) {
        System.setOut(new PrintStream(System.out) {
            @Override
            public void println(String val) {
                switch (val) {
                    case "a=10":
                        super.println("a=100");
                        break;
                    case "b=10":
                        super.println("b=200");
                        break;
                    default:
                        super.println(val);
                }
            }
        });
    }

}
