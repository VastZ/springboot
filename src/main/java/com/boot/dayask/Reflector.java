package com.boot.dayask;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Reflector {
    public static void main(String[] args) throws Exception {
        Set s = new HashSet();
        s.add("foo");
        // 这句话获取的是hashSet中hashMap中keyset返回的iterator
        Iterator i = s.iterator();
        Method m = i.getClass().getMethod("hasNext", new Class[0]);
        // m 反射得到的是的  HashMap$HashIterator 中的 hasNext方法 他是使用 public final 修饰的
//        m.setAccessible(true);
        // 没有上面这句话会报 Exception in thread "main" java.lang.IllegalAccessException:
        // Class com.boot.dayask.Reflector can not access a member of class
        // java.util.HashMap$HashIterator with modifiers "public final"
        System.out.println(m.invoke(i, new Object[0]));
    }
}
