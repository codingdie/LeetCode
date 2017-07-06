package com.codingdie.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xupen on 2017/7/6.
 */
public class SubSet {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        subsetsRe(nums, 0, res, new ArrayList<>());
        return res;
    }

    public void subsetsRe(int[] nums, int start, List<List<Integer>> res, List<Integer> cur) {
        res.add(new ArrayList<>(cur));
        for (int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
            subsetsRe(nums,i+1,res,cur);
            cur.remove(cur.size()-1);
        }
    }
}
