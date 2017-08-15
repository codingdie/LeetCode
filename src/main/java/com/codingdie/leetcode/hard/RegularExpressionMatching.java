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

    public boolean isMatch2(String s, String p) {
        boolean[][] res = new boolean[s.length()][p.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (j + 1 < p.length() && p.charAt(j + 1) == '*') {

                } else {
                    res[i][j] = res[i - 1][j - 1] && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0));
                }
            }
        }
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
