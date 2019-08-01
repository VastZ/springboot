package com.boot.learn.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapDemo {

    public static void main(String[] args) {

        HashMap<Integer, Object> map = new HashMap<>(12);
        for(int i = 0; i < 30; i++){
            map.put(i, "a" + i);
        }
        map.entrySet();
        System.out.println("map 的大小" + map.size());

        ConcurrentHashMap<Integer, Object> conMap = new ConcurrentHashMap<>();
        conMap.put(1, "222");
        conMap.get(1);

    }

}
