package com.boot.dayask;

/**
 * @author zhang.wenhan
 * @description a
 * @date 2019/7/19 11:34
 */
public class AnimalFarm {

    public static void main(String[] args) {
        final String pig = "length: 10";
        final String dog = "length: " + pig.length();
        System.out.println(dog);
        System.out.println(pig);
        System.out.println(pig == dog);
        System.out.println(pig == dog.intern());
        System.out.println(pig.equals(dog));
        System.out.println("Animals are equal: "
                + pig == dog);
    }
}