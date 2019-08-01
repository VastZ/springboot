package com.boot.learn.genericity;

/**
 * @author zhang.wenhan
 * @description Plate
 * @date 2019/7/4 15:37
 */
public class Plate<T extends Fruit> {

    private T item;

    public Plate(T t){item=t;}

    public void set(T t){item=t;}

    public T get(){return item;}

}
