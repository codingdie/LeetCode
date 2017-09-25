package com.codingdie.leetcode.medium;

/**
 * Created by xupeng on 2017/9/25.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp=new int[m][n];
        dp[0][0]=grid[0][0];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int left=Integer.MAX_VALUE;
                int bottom=Integer.MAX_VALUE;
                if(i-1>=0){
                    bottom=dp[i-1][j];
                }
                if(j-1>=0){
                    left=dp[i][j-1];
                }
                if(i==0&&j==0)continue;
                dp[i][j]=Math.min(left,bottom)+grid[i][j];
            }
        }
        return dp[m][n];
    }
}
