package com.boot.test;

import java.lang.reflect.Field;

public class IntegerTest {
    
    // 如何改变一个Integer的值
    public static void main(String[] args) {
        Integer i = new Integer(1);
        change(i);
        System.out.println(i);
    }
    // 使用反射获取其属性，然后重新设置值。
    private static void change(Integer i) {
        try {
//            Field f = i.getClass().getField("value");
            Field f = i.getClass().getDeclaredField("value");
            f.setAccessible(true);
            f.set(i, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
