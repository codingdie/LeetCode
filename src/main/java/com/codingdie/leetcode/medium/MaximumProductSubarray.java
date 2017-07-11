package com.codingdie.leetcode.medium;

import java.util.Arrays;

/**
 * Created by xupen on 2017/7/10.
 */
public class MaximumProductSubarray {
    //2重动态规划
    public int maxProduct(int[] nums) {
        int dpmax=nums[0];
        int dpmin=nums[0];
        int max=nums[0];
        for (int i = 1; i < nums.length; i++) {
            int dpmax1=Math.max(Math.max(nums[i],nums[i]*dpmax),nums[i]*dpmin);
            int dpmin1=Math.min(Math.min(nums[i],nums[i]*dpmax),nums[i]*dpmin);
            if(dpmax1>max){
                max=dpmax1;
            }
            dpmax=dpmax1;
            dpmin=dpmin1;
        }
        return max;
    }

    public static void main(String[] args) {
        new MaximumProductSubarray().maxProduct(new int[]{-2,3,-4});
    }
}
