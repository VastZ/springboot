package com.boot.learn.genericity;

/**
 * 泛型测试类
 * @author zhang.wenhan
 * @description GenericTest
 * @date 2019/7/4 15:38
 */
public class GenericityTest {

    public static void main(String[] args) {
        Plate<? extends Fruit> plate = new Plate<Apple>( new Apple());
        // PECS（Producer Extends Consumer Super）原则，已经很好理解了：
        //1. 频繁往外读取内容的，适合用上界Extends。
        //2. 经常往里插入的，适合用下界Super。

    }

}
