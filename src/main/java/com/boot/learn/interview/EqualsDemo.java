package com.boot.learn.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class EqualsDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello,world");
        Vector<String> vector = new Vector<>();
        vector.add("hello,world");
        // true 两个类型都重写了equals方法，比较了内容和元素长度，并未对类型进行首要比对
        // AbstractList 中重写了 equals方法
        System.out.println(list.equals(vector));
        String str = "";
        // 支持 char byte short int Character Byte Short Integer String Enum
        switch (str) {
            case "1":
                System.out.println(str);
            default:
                System.out.println("default");
        }
    }

}
