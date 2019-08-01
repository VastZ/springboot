package com.boot.learn.algorithm;

/**
 * @author zhang.wenhan
 * @description ChooseSortDemo
 * @date 2019/6/18 19:01
 */
public class ChooseSortDemo {

    public static void main(String[] args) {
        int[] ints = { 5, 3, 1,8,4,39,11, 48, 22};
        chooseSort(ints);
    }

    private static void chooseSort(int[] ints){
        for(int i =0; i < ints.length; i++){
            int min = i;
            for(int j = i + 1; j < ints.length; j ++){
                if(ints[j] < ints[min]){
                    min = j;
                }
            }
            if (i != min){
                int temp  = ints[i];
                ints[i] = ints[min];
                ints[min] = temp;
            }
        }

        for(int i =0; i < ints.length; i++){
            System.out.print(ints[i]);
            System.out.print(",");
        }

    }

}
