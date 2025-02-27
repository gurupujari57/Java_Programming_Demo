package org.dsa.slidingWindow;

public class MinSubArraySum {
    public static void main(String[] args) {
        int [] nums = {2,3,1,2,4,3};
        int target = 7;
        int minres = minSubArrayLen(target, nums);
        System.out.println(minres);

        int maxres = maxSubArrayLen(target, nums);
        System.out.println(maxres);
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int i=0,j=0, sum=0;
        int min = Integer.MAX_VALUE;
        while(j<nums.length){
            sum=sum+nums[j];
            while(sum>=target){
                min=Math.min(j-i+1,min);
                sum=sum-nums[i];
                i++;
            }
            j++;
        }
        return (min==Integer.MAX_VALUE)?0:min;
    }

    public static int maxSubArrayLen(int target, int[] nums) {
        int i=0,j=0, sum=0;
        int min = Integer.MIN_VALUE;
        while(j<nums.length){
            sum=sum+nums[j];
            while(sum>target){
                min=Math.max(j-i+1,min);
                sum=sum-nums[i];
                i++;
            }
            j++;
        }
        return (min==Integer.MIN_VALUE)?0:min;
    }
}
