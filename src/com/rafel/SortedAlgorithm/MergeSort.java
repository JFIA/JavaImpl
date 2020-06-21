package com.rafel.SortedAlgorithm;

import java.util.Arrays;

public class MergeSort {

    public void sort(int[] arr, int start, int end) {

        // 递归到单个元素返回
        if (start >= end) return;

        int mid = start + (end - start) / 2;
        sort(arr, start, mid);
        sort(arr, mid + 1, end);

        // 排序并合并
        merge(arr, start, mid, end);

    }

    public void merge(int[] arr, int start, int mid, int end) {

        int[] temp = new int[arr.length];

        // 需要合并的两个数组在原数组的起始位置
        int i = start;
        int j = mid + 1;
        // 临时数组长度
        int len = 0;

        while (i <= mid && j <= end) {
            if (arr[i] < arr[j])
                temp[len++] = arr[i++];
            else
                temp[len++] = arr[j++];

        }

        // 左边数组有剩余
        while (i <= mid) {
            temp[len++] = arr[i++];

        }

        // 右边数组有剩余
        while (j <= end) {
            temp[len++] = arr[j++];
        }

        for (int t = 0; t < len; t++) {
            arr[t + start] = temp[t];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1, 5, 4};

        MergeSort mergeSort = new MergeSort();

        mergeSort.sort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }
}
