package com.rafel.SortedAlgorithm;

import java.util.Arrays;

/**
 * 堆排序的基本思想是：将待排序序列构造成一个大顶堆，此时，整个序列的最大值就是堆顶的根节点。将其与末尾元素进行交换，
 * 此时末尾就为最大值。然后将剩余n-1个元素重新构造成一个堆，这样会得到n个元素的次小值。
 * 如此反复执行，便能得到一个有序序列了
 */
public class HeapSort {
    public static void sort(int[] arr) {
        // 构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            // 从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }

        // 调整堆结构，交换堆顶元素和末尾元素，使末尾元素最大(升序排序)
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            // 重新对堆进行调整，从堆顶到以交换的末尾元素位置
            adjustHeap(arr, 0, i);
        }
    }

    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];

        // 从i结点的左子结点开始，也就是2i+1处开始
        for (int k = 2 * i + 1; k < length; k = k * 2 + 1) {
            // 如果左子结点小于右子结点，k指向右子结点
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }

            if (arr[k] > temp) {
                // 如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            } else break;
        }

        // 将temp值赋予最终那个位置
        arr[i] = temp;

    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }

}
