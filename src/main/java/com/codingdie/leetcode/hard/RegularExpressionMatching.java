package com.codingdie.leetcode.hard;

/**
 * Created by xupeng on 17-8-14.
 */
public class RegularExpressionMatching {
    public static void main(String[] args) {
        RegularExpressionMatching regularExpressionMatching = new RegularExpressionMatching();
        System.out.println(regularExpressionMatching.isMatch("bbbba", ".*a*a"));
    }

    public boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0);
    }

    public boolean isMatch(String s, String p, int i, int j) {
        if (j >= p.length() && i >= s.length()) return true;
        if (i < s.length() && j >= p.length()) return false;
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            if (i < s.length()) {
                if (isMatch(s, p, i, j + 2)) return true;
                while (i < s.length() && (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i))) {
                    if (isMatch(s, p, i + 1, j + 2)) {
                        return true;
                    }
                    i++;
                }
                return false;
            } else {
                return isMatch(s, p, i, j + 2);
            }
        } else {
            if (i < s.length()) {
                return (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) && isMatch(s, p, i + 1, j + 1);
            } else {
                return false;
            }
        }
    }
}
