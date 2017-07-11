package com.codingdie.leetcode.easy;

/**
 * Created by xupen on 2017/7/11.
 */
public class MinStack {
    int total = 16;
    int cur = 0;
    int[] data = new int[total];
    int min = Integer.MAX_VALUE;

    public MinStack() {

    }

    public void push(int x) {
        if (cur >= total) {
            int[] newdata = new int[total * 2];
            System.arraycopy(data, 0, newdata, 0, total);
            data = newdata;
            total *= 2;
        }
        data[cur] = x;
        cur++;
        if (x < min) {
            min = x;
        }
    }

    public void pop() {
        cur--;
        if (data[cur] == min) {
            min = Integer.MAX_VALUE;
            for (int i = 0; i < cur; i++) {
                if (data[i] < min) min = data[i];
            }
        }
    }

    public int top() {
        return cur > 0 ? data[cur - 1] : 0;
    }

    public int getMin() {
        return min;
    }
}
