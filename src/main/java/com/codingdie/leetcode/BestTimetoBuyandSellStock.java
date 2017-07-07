package com.codingdie.leetcode;

/**
 * Created by xupen on 2017/7/7.
 */
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE;
        int max=0;
        for(int v:prices){
            min=Math.min(min,v);
            max=Math.max(max,v-min);
        }
        return max;
    }
}
