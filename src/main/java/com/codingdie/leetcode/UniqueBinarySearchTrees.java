package com.codingdie.leetcode;

/**
 * Created by xupen on 2017/7/7.
 */
public class UniqueBinarySearchTrees {

    //递归回溯遍历过慢 采用dp


    public int numTrees(int n) {
        int[] dp =new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new UniqueBinarySearchTrees().numTrees(5));
    }
}
