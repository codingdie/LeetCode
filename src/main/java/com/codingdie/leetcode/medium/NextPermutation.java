package com.codingdie.leetcode.medium;


/**
 * Created by xupeng on 17-8-30.
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len < 2) return;
        if (nums[len - 1] > nums[len - 2]) {
            int tmp = nums[len - 1];
            nums[len - 1] = nums[len - 2];
            nums[len - 2] = tmp;
        } else {
            int i = len;
            while (--i >= 0) {
                if (i == 0) break;
                if (nums[i - 1] < nums[i]) {
                    int tmp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = tmp;
                    break;
                }
            }
        }
    }
}
