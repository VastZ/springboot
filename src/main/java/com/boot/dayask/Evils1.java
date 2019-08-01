package com.boot.dayask;

/**
 * @author zhang.wenhan
 * @description Evils1
 * @date 2019/8/1 15:26
 */
public class Evils1 {

    public static final Evils1 EVILS_1 = new Evils1(); // 加载顺序的问题，还没有初始化living

//    private static Evils1 EVILS_1; //
//
//    public static Evils1 getInstance(){
//        return new Evils1();
//    }

    private Evils1(){
    }

    private static  final Boolean living = true;

    private final  Boolean alive = living;

    public final Boolean lives(){
        return alive;
    }

    public static void main(String[] args) {
//        System.out.println(Evils1.getInstance().lives() ? "a " : "b" );
        System.out.println(EVILS_1.lives() ? "a " : "b" );
    }


}
