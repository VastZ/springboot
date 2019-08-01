package com.boot.dayask;

/**
 * @author zhang.wenhan
 * @description PowerOfTen
 * @date 2019/7/24 8:56
 */
public enum PowerOfTen {
    ONE(1), TEN(10),
    HUNDRED(100) {
        @Override
        public String toString() {
            return Integer.toString(super.val);
        }
    };
    // non-static field cannot be referenced from a static context
    // private 访问范围 编译报错
    private final int val;

    PowerOfTen(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }

    public static void main(String[] args) {
        System.out.println(ONE + " " + TEN + " " + HUNDRED);
    }
}