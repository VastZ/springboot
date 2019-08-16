package com.boot.dayask;

import java.lang.reflect.Field;

/**
 * @author zhang.wenhan
 * @description IntegerChange
 * @date 2019/8/16 11:27
 */
public class IntegerChange {

    public static void main(String[] args) throws Exception {
        // 当创建Integer对象时，不使用new Integer（int i）语句，大小在-128~127之间，对象存放在Integer常量池中
        // -128到127 这个127的值是可以改变的，如设置-Djava.lang.Integer.IntegerCache.high=600
        // -XX:AutoBoxCacheMax必须大于128才会生效
        Integer a = Integer.parseInt("10");
//        Integer a = new Integer("10");
        Integer b = Integer.valueOf(10);
        Integer c = 10;
        changeValue(a, 100);
        changeValue(b, 200);
        changeValue(c, 300);
        System.out.printf("%d %d %d", a, b, c);
    }

    private static void changeValue(Integer i, int value) throws Exception {
        Field field = Integer.class.getDeclaredField("value");
        field.setAccessible(true);
        field.set(i, value);
    }
}