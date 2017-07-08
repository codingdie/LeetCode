package com.codingdie.leetcode;

/**
 * Created by xupeng on 2017/7/8.
 */
public class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
    void print() {
        RandomListNode t = this;
        StringBuffer stringBuffer = new StringBuffer();
        while (t != null) {
            stringBuffer.append(t.label +":"+random.label+ ",");
            t = t.next;
        }
        System.out.println(stringBuffer.substring(0, stringBuffer.length() - 1));
    }
}
