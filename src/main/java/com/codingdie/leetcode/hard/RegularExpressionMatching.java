package com.codingdie.leetcode.hard;

import com.codingdie.leetcode.TestUtil;

/**
 * Created by xupeng on 17-8-14.
 */
public class RegularExpressionMatching {
    public static void main(String[] args) {
        RegularExpressionMatching regularExpressionMatching = new RegularExpressionMatching();
        System.out.println(regularExpressionMatching.isMatch2("aaa", ".*"));

    }

    public boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0);
    }

    public boolean isMatch3(String s, String p) {
        boolean[][] res = new boolean[p.length()][s.length()];
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                if (p.charAt(i - 1) == '.') {
                    for (int j = 0; j < s.length(); j++) {
                        res[i][j] = true;
                    }
                } else {
                    for (int j = 0; j < s.length(); j++) {
                        if (i > 1 && res[i - 2][j] == true) {
                            res[i][j] = res[i - 2][j];
                            continue;
                        }
                        res[i][j] = p.charAt(i) == s.charAt(j);
                        if (i > 0 && j > 0) {
                            res[i][j] = res[i][j] && res[i - 1][j - 1];
                        }
                    }
                }
            } else {

                for (int j = 0; j < s.length(); j++) {
                    res[i][j] = p.charAt(i) == s.charAt(j);
                    if (i > 0 && j > 0) {
                        res[i][j] = res[i][j] && res[i - 1][j - 1];
                    }
                }
            }
        }
        TestUtil.printArray(res);

        return res[p.length() - 1][s.length() - 1];
    }

    public boolean isMatch2(String s, String p) {
        boolean[][] res = new boolean[p.length() + 1][s.length() + 1];
        res[0][0] = true;
        for (int i = 0; i < s.length(); i++) {
            res[0][i + 1] = false;
        }
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*')
                res[i + 1][0] = res[i - 1][0];
            else
                res[i + 1][0] = false;
        }
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                for (int j = 0; j < s.length(); j++) {
                    if (i > 0 && res[i - 1][j + 1] == true) {
                        res[i + 1][j + 1] = true;
                        continue;
                    }
                    if (res[i][j + 1] == true) {
                        res[i + 1][j + 1] = true;
                        continue;
                    }
                    res[i + 1][j + 1] = (p.charAt(i - 1) == s.charAt(j) || p.charAt(i - 1) == '.') && res[i][j];
                }
            } else {
                for (int j = 0; j < s.length(); j++) {
                    res[i + 1][j + 1] = (p.charAt(i) == s.charAt(j) || p.charAt(i) == '.') && res[i][j];
                }
            }
        }
        return res[p.length()][s.length()];
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
