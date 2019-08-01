package com.boot.learn.datastructure.arrays;

/**
 * @author zhang.wenhan
 * @description ArrayBasic
 * @date 2019/7/22 14:28
 */
public class ArrayBasic {

    public static void main(String[] args) {

        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++)
            arr[i] = i;

        int[] scores = new int[]{100, 99, 66};
        for (int i = 0; i < scores.length; i++)
            System.out.println(scores[i]);

        for (int score : scores)
            System.out.println(score);

        scores[0] = 96;

        for (int i = 0; i < scores.length; i++)
            System.out.println(scores[i]);
    }

}
