package com.codingdie.leetcode.medium;

import java.util.Arrays;
import java.util.List;

/**
 * Created by xupen on 2017/7/10.
 */
public class WordBreak {
    //动态规划
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean dp[]=new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1;i<=s.length();i++){
            for(int j=i-1;j>=0;j--){
                if(dp[j]==false)continue;
                if(wordDict.contains(s.substring(j,i))){dp[i]=true ;break;}
            }
        }
        return  dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(new WordBreak().wordBreak("leetcode", Arrays.asList("leet","code")));
    }
}
