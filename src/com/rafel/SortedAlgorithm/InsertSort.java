package com.rafel.SortedAlgorithm;

import java.util.Arrays;

public class InsertSort {
    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int temp = arr[i];
            while (j > 0 && arr[j - 1] > temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 2, 4, 1, 5};
        InsertSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
