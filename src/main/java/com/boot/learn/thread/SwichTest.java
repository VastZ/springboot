package com.boot.learn.thread;

import java.time.Instant;

/**
 * @author zhang.wenhan
 * @description SwichTest
 * @date 2019/7/4 16:55
 */
public class SwichTest {

    public static void main(String[] args) {
        method(null);

        Instant instant  =  Instant.now();
    }

    public static void method(String param) {
        // 当 switch 括号内的变量类型为 String 并且此变量为外部参数时，必须先进行 null判断。
        switch (param) {
            // 肯定不是进入这里
            case "sth":
                System.out.println("it's sth");
                break;
            // 也不是进入这里
            case "null":
                System.out.println("it's null");
                break;
            // 也不是进入这里
            default:
                System.out.println("default");
        }
    }
}
