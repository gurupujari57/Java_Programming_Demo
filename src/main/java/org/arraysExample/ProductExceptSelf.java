package org.arraysExample;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        int arr[]= {1,2,3,4,5};
        productItself(arr);
    }
    public static void productItself(int[] arr){
        int []res=new int[arr.length];
        Arrays.fill(res, 1);

        for(int i=0;i< arr.length;i++){
            for(int j=0;j< arr.length;j++){
                if(i!=j){
                   res[i] = res[i]*arr[j];
                }
            }
        }
        System.out.print(Arrays.toString(res)+",");

    }
}
