package com.codingdie.leetcode.easy;

/**
 * Created by xupeng on 2017/7/8.
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int l=0;
        char[] chars=s.toCharArray();
        for(int i=chars.length-1;i>=0;i--){
            if(chars[i]==' '&&l==0)continue;
            if(chars[i]==' '&&l!=0)return l;
            l++;
        }
        return l;
    }
}
