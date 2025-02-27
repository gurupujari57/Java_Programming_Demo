package org.dsa.slidingWindow;

import java.util.Arrays;

public class MaxSumSubArray {
    public static void main(String[] args) {
        int[] arr = {2,5,1,8,2,9,1};
        System.out.println(Arrays.toString(arr));
        int sum = getSum(arr, 3);
        System.out.println("Max Sum :: "+sum);
    }
    public static int getSum(int[] arr, int k){
        int i=0,j=0,sum=0;
        Integer max = Integer.MIN_VALUE;
        while (j<arr.length){
            sum = sum+arr[j];
            if(j-i+1<k){
                j++;
            } else if (j-i+1==k) {
                max=Math.max(sum,max);
                sum=sum-arr[i];
                i++;
                j++;
            }
        }
        return max;
    }

}
