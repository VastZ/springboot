package com.boot.dayask;

import java.util.IdentityHashMap;
import java.util.Map;

/**
 * @author zhang.wenhan
 * @description MyMap
 * @date 2019/8/14 13:12
 */
public class MyMap {

    public static void main(String[] args) {
        Map map = new IdentityHashMap<>();
        map.put(1, "Hello");
        map.putIfAbsent(1, "World");
        print(map.get(1));
        print(map.size());
        // IdentityHashMap 比较key使用 key1 == key2 而不是hashmap那种 key1.equals(key2)
        // put时 1024 会进行装箱操作，相当于new Integer() 而 Integer 有缓存为 -128-127
        map.put(1024, "A");
        map.putIfAbsent(1024, "B");
        print(map.get(1024));
        print(map.size());

    }

    private static void print(Object object) {
        System.out.print(object + " ");
    }
}