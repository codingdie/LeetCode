package com.codingdie.leetcode.hard;

import java.util.Stack;

/**
 * Created by xupeng on 17-8-29.
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        new LongestValidParentheses().longestValidParentheses("()()");
    }

    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 0) {
            return 0;
        }
        Stack<Character> stack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();

        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == '(') {
                stack.push(ch);
                indexStack.push(i);
            } else if (ch == ')') {
                if (stack.size() != 0 && stack.peek() == '(') {
                    stack.pop();
                    indexStack.pop();
                } else {
                    indexStack.push(i);
                }
            } else {

                indexStack.push(i);
            }
        }
        return max;
    }

}
