package com.codingdie.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by xupen on 2017/7/7.
 */
public class SingleNumber {

    //位运算抑或最快
    public int singleNumber(int[] nums) {
        for(int i=1;i<nums.length;i++){
            nums[0]=nums[0]^nums[i];
        }
        return nums[0];
    }
}
