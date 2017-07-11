package com.codingdie.leetcode.easy;

/**
 * Created by xupen on 2017/7/11.
 */
public class HouseRobber {

    public static void main(String[] args) {
        new HouseRobber().rob(new int[]{2, 1, 1, 2});
    }

    //dp
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int dp1 = nums[0];
        int dp2 = 0;
        int dp3 = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp1 = dp2 + nums[i];
            dp2 = dp3;
            dp3 = Math.max(dp1, dp2);
        }
        return dp3;
    }
}