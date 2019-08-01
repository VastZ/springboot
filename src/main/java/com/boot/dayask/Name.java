package com.boot.dayask;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhang.wenhan
 * @description v
 * @date 2019/7/17 10:39
 */
public class Name {
    private String first, last;

    public Name(String first, String last) {
        if (first == null || last == null)
            throw new NullPointerException();
        this.first = first;
        this.last = last;
    }

    // 此时不是重写了Object的 equals 方法 故使用的还是原来的Object.equals 比较的是内存地址
    public boolean equals(Name o) {
        return first.equals(o.first) && last.equals(o.last);
    }

    // 如果是重写Object的equals(Object obj) 方法输出true
    @Override
//    public boolean equals(Object obj) {
//        Name o = (Name) obj;
//        return first.equals(o.first) && last.equals(o.last);
//    }
    // hashCode 也需要重写 在set中比较的时候会比较 hashcode 和 key
    public int hashCode() {
        return 31 * first.hashCode() + last.hashCode();
    }

    public static void main(String[] args) {
        Set s = new HashSet();
        s.add(new Name("Mickey", "Mouse"));
        System.out.println(s.contains(new Name("Mickey", "Mouse")));
        // 结果为fasle

    }
}