package com.boot.learn.thread;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zwh
 */
public class ThreadLocalUtil {

    private static  ThreadLocal<Map<String,Object>> threadLocal = new ThreadLocal<Map<String, Object>>();

    /**
     * 设置本地值
     */
    public static void setThreadLocal(String key,Object value){
        if(StringUtils.isEmpty(key)||value ==null){
            return;
        }
        Map<String, Object> threadLocalMap = threadLocal.get();
        if(threadLocalMap == null){
            threadLocalMap = new HashMap<String,Object>();
        }
        threadLocalMap.put(key,value);
        threadLocal.set(threadLocalMap);
    }
    /**
     * 获取本地值
     */
    public static Object getThreadLocal(String key){
        if(StringUtils.isEmpty(key)){
            return null;
        }
        Map<String, Object> threadLocalMap = threadLocal.get();
        System.out.println("当前线程" + Thread.currentThread().getName() + "的threadLocal地址" + threadLocal);
        System.out.println("当前线程" + Thread.currentThread().getName() + "threadLocalMap" + threadLocalMap);
        if(threadLocalMap != null){
            System.out.println(threadLocalMap.size());
            return threadLocalMap.get(key);
        }
        return null;
    }

    /**
     * 清空本地值
     */
    public static void removeThreadLocal(){
        threadLocal.remove();
    }


}
