package com.boot.test;

/**
 * @author zhang.wenhan
 * @description FinallyTest
 * @date 2019/7/5 8:35
 */
public class FinallyTest {

    public static void main(String[] args) {

        System.out.println(test().toString());

    }

    private static User test(){
        User u = new User();
        try {
            u.setName("张三");
            System.out.println("try 执行了: " + u.toString());
            return u;
        } finally {
            u.setName("李四");
            System.out.println("finally 来了" + u.toString());
        }

    }

}
