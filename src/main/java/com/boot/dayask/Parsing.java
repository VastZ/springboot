package com.boot.dayask;

/**
 * @author zhang.wenhan
 * @description A
 * @date 2019/7/30 8:39
 */
public class Parsing {
    /**
     * Returns Integer corresponding to s, or null if s is null.
     * @throws NumberFormatException if s is nonnull and
     * doesn't represent a valid integer
     */
    public static Integer parseInt(String s) {
        return (s == null) ?
                (Integer) null : Integer.parseInt(s);
//                (Integer) null : Integer.valueOf(s);
    }

    // 感觉这一题大家都被(Integer) null误导了，其实(Integer) null是不会报空指针的，
    // 真正的原因来自于隐藏的拆箱操作，因为三元表达式前后类型不一致，
    // 前面是Integer类型，后面是int类型，所以这里会先将(Integer) null的值拆成int类型，
    // 把一个null赋值给一个int类型的变量就会存在空指针。
    // 这里如果把三元表达式后面的parseInt 方法改成valueOf方法就没有空指针。
    public static void main(String[] args) {
        System.out.println(parseInt("-1") + " " +
                parseInt(null) + " " +
                parseInt("1"));
    }
}