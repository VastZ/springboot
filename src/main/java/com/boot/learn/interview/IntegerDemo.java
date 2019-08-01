package com.boot.learn.interview;

import java.util.Objects;

public class IntegerDemo {

    public static void main(String[] args) {
        Integer a = 200;
        int b = 200;
        Integer c = 200;
        // 自动装箱和自动拆箱操作
        System.out.println(a == b);

        System.out.println(a == c);

        System.out.println(a.equals(c));

        System.out.println(Objects.equals(a,c));
    }


}
