package org.dsa.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 3, 9, 1, 5, 7, 2, 6, 4};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int [] arr, int left, int right){
        //if partition is invalid or single element in array
        if(left>=right)
            return;
        //divide array in two equal position
        int mid=(left+right)/2;
        //sort left position
        mergeSort(arr,left,mid);
        //sort right position
        mergeSort(arr,mid+1,right);

        //Temporary Array for merge
        int [] temp = new int[right-left+1];

        //merge two sorted partition into temp array
        int i=left, j=mid+1, k=0;
        //compare elements from both position
        while(i<=mid && j<=right){
            if(arr[i]<arr[j]){
                temp[k++]=arr[i++];
            }else {
                temp[k++]=arr[j++];
            }
        }
        //copy remaining element
        while (i<=mid){
            temp[k++]=arr[i++];
        }
        while (j<=right){
            temp[k++]=arr[j++];
        }
        //overrite tem array back to original array
        for(i=0;i<temp.length;i++){
            arr[left+i]=temp[i];
        }


    }
}
