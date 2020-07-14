package com.rafel.SortedAlgorithm;

import java.util.Arrays;

public class SelectionSort {
    public static void sort(int[] arr){
        for (int i=0;i<arr.length-1;i++){
            int k=i;
            for (int j=i+1;j<arr.length;j++){
                if (arr[j]<arr[k]){
                    k=j;
                }
            }
            if (k!=i){
                int temp=arr[k];
                arr[k]=arr[i];
                arr[i]=temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a=new int[]{3,2,1,5,4};
        SelectionSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
