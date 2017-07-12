package com.codingdie.leetcode.medium;

/**
 * Created by xupen on 2017/7/12.
 */
public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {
        int min=0;
        int[] dp=new int[nums.length];
        int[] dp2=new int[nums.length];

        dp[0]=nums[0]==s?1:0;
        dp2[0]=nums[0]==s?0:nums[0]>s?0:nums[0];

        for(int i=1;i<nums.length;i++){
            if(dp[i-1]==0){

            }else{

            }
        }
        return min;
    }
}
