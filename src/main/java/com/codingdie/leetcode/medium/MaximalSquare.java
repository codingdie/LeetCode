package com.codingdie.leetcode.medium;

import com.codingdie.leetcode.TestUtil;

/**
 * Created by xupen on 2017/7/13.
 */
public class MaximalSquare {
    //有更高效的dp
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0)return 0;
        int max=0;
       int[][] dp=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                char ch = matrix[i][j];
                if(i==0||j==0){
                    dp[i][j]= ch =='1'?1:0;
                }else{
                    if(ch=='1'){
                        dp[i][j]=1;
                        int len=dp[i-1][j-1];
                        for(int k=0;k<len;k++){
                            if(matrix[i-1-k][j]=='1'&&matrix[i][j-1-k]=='1'){
                                dp[i][j]++;
                            }else{
                                break;
                            }
                        }

                    }
                }
                max=Math.max(dp[i][j],max);
            }
        }
        TestUtil.printArray(matrix);
        System.out.println();
        TestUtil.printArray(dp);
        return max*max;
    }

    public static void main(String[] args) {
       ;
        new MaximalSquare().maximalSquare(TestUtil.getCharArray(new String[]{"0110111111111111110","1011111111111111111","1101111111110111111","1111111111111011111","1111111111111101111","1110111011111111101","1011111111111101111","1111111111111110110","0011111111111110111","1101111111011111111","1111111110111111111","0110111011111111111","1111011111111101111","1111111111111111111","1111111111111111111","1111111111111111101","1111111101101101111","1111110111111110111"}));
    }

}
