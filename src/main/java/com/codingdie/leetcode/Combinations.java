package com.codingdie.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xupen on 2017/7/6.
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n == 0 || k == 0 || n < k) {
            return result;
        }
        List<Integer> res = new ArrayList<>();
        combineRe(result, res, k, 0, n);
        return result;
    }

    public void combineRe(List<List<Integer>> result, List<Integer> cur, int k, int start, int n) {
        if (k == 0) {
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i = start; i < n; i++) {
            cur.add(i + 1);
            combineRe(result, cur, k - 1, i + 1, n);
            cur.remove(cur.size() - 1);
        }
    }
}

