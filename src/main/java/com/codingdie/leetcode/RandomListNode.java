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
        RandomListNode t=this;
        StringBuffer stringBuffer = new StringBuffer();
        while (t != null) {
            stringBuffer.append(t.label);
            if(t.random!=null){
                stringBuffer.append(":"+t.random.label);
            }
            stringBuffer.append("\t");
            t = t.next;
        }
        System.out.println(stringBuffer.toString());
    }
}
