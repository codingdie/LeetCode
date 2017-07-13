package com.codingdie.leetcode.medium;

import java.util.Arrays;

/**
 * Created by xupen on 2017/7/13.
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);

        return nums[nums.length-k];
    }
}
