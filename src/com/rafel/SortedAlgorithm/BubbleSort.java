package com.rafel.SortedAlgorithm;

import java.util.Arrays;

public class BubbleSort {

    public static void sort(int[] nums) {

        // 冒泡排序次数
        for (int i = 0; i < nums.length; i++) {
            // 升序，末尾最大
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j - 1] > nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 2, 1, 7, 4, 5};
        sort(a);

        System.out.println(Arrays.toString(a));
    }
}
