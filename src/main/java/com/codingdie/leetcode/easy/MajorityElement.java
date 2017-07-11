package com.codingdie.leetcode.easy;

/**
 * Created by xupen on 2017/7/11.
 */
public class MajorityElement {
    public static void main(String[] args) {
        new MajorityElement().majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
    }

    //抵消法
    public int majorityElement(int[] nums) {
        int major = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                major = nums[i];
                count++;
            } else {
                if (nums[i] != major) {
                    count--;
                } else count++;
            }
        }
        return major;
    }
}
