package com.codingdie.leetcode.hard;

/**
 * Created by xupeng on 17-8-29.
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses().longestValidParentheses("(()))()"));
    }

    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 0) {
            return 0;
        }
        int[] stack = new int[chars.length];
        int t = -1;
        int start = 0;
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == '(') {
                stack[++t] = i;
            } else if (ch == ')') {
                if (t == -1) {
                    start = i + 1;
                } else {
                    t--;
                    if (t == -1) {
                        max = Math.max(max, i - start + 1);
                    } else {
                        max = Math.max(max, i - stack[t]);
                    }
                }
            } else {
                t = -1;
                start = i + 1;
            }
        }
        return max;
    }

}
