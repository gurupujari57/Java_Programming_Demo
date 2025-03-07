package org.example;

import java.util.Arrays;

public class PrefixSumArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};  //o/p={1,3,6,10,15,21,28}
        System.out.println(Arrays.toString(arr));
        for (int i=1;i<arr.length;i++){
            arr[i] += arr[i-1];         //arr[i]=arr[i]+arr[i-1]
        }
        System.out.print(Arrays.toString(arr));
    }
}
