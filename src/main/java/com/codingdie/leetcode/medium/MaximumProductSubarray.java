package com.codingdie.leetcode.medium;

/**
 * Created by xupen on 2017/7/10.
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int[] dpmax = new int[nums.length];
        int[] dpmin = new int[nums.length];
        dpmax[0]=nums[0];
        dpmin[0]=nums[0];

        for (int i = 1; i < nums.length; i++) {
//           int proMin=dpmin[i-1]*nums[]
        }
        return 0;


    }
}
