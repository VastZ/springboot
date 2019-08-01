package com.boot.learn.algorithm;


import java.util.Arrays;

public class DoubleArraySortDemo {

    public static void main(String[] args) {
        sort();
    }

    private static void sort() {
        int[] arr2 = {1, 2, 3, 5, 7};
        int[] arr1 = {4, 6, 8};

        int length1 = arr1.length;
        int length2 = arr2.length;
        int[] arr = new int[length1 + length2];
        if (arr2[0] >= arr1[length1 - 1]) {
            arr = connectArr(arr1, arr2);
        }
        if (arr1[0] >= arr2[length2 - 1]) {
            arr = connectArr(arr2, arr1);
        }
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        int count = 0;
        while (true) {
            count++;
            if (index1 == arr1.length) {
                System.arraycopy(arr2, index2, arr, index, arr2.length - index2);
                break;
            }
            if (index2 == arr2.length) {
                System.arraycopy(arr1, index1, arr, index, arr1.length - index1);
                break;
            }
            if (arr1[index1] <= arr2[index2]) {
                arr[index] = arr1[index1];
                index1++;
            } else {
                arr[index] = arr2[index2];
                index2++;
            }
            index++;
        }
        printArr(arr);
        System.out.println("总循环次数:" + count);
    }

    private static int[] connectArr(int[] arr1, int[] arr2) {
        int[] arr = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, arr, 0, arr1.length);
        System.arraycopy(arr2, 0, arr, arr1.length, arr2.length);
        return arr;
    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
