package com.boot.learn.algorithm;

public class MaopaoDemo {

    public static void main(String[] args) {
        int[] ints = {9, 3, 3, 5, 2, 7, 8, 11, 14, 18};
         ints = sort(ints);

    }

    private static int[] sort(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints.length - 1; j++) {
                if (ints[j] > ints[j + 1]) {
                    int temp = ints[j];
                    ints[j] = ints[j + 1];
                    ints[j + 1] = temp;
                }
            }
        }
        return ints;
    }

    private static  void print(int[] ints){
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
        System.out.println();
    }
}
