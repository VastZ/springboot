package com.boot.learn.collection;

import java.util.*;

public class ListDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        for (String s : list){
            System.out.println(s);
        }
        System.out.println("添加d到第一个 ----");
        list.add(0, "d");
        for (String s : list){
            System.out.println(s);
        }
        Map<String, Object> map = Collections.synchronizedMap(new HashMap<>());
    }

}
