package com.codingdie.leetcode;

/**
 * Created by xupen on 2017/7/6.
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            if (i - 2 >= 0) {
                dp[i] += dp[i - 2];
            }
            if (i - 1 >= 0) {
                dp[i] += dp[i - 1];
            }
        }
        return dp[n];
    }

}
