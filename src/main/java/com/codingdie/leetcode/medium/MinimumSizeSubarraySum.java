package com.codingdie.leetcode.medium;

/**
 * Created by xupen on 2017/7/12.
 */
public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        int j = -1;
        int i = 0;
        int total = 0;
        for (; i < nums.length; i++) {
            if (i > 0) {
                if (total < s) break;
                total -= nums[i - 1];
            }
            if (total >= s) {
                min = Math.min(min, j - i + 1);
                continue;
            }
            while (++j < nums.length) {
                total += nums[j];
                if (total >= s) {
                    min = Math.min(min, j - i + 1);
                    break;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}
