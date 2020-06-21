package com.rafel.SortedAlgorithm;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) return mid;
                // 目标数在右半区
            else if (arr[mid] < target) {
                left = mid + 1;
            }
            // 目标数在左半区
            else if (arr[mid] > target) {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int i = binarySearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 5);
        System.out.println(i);
    }

}
