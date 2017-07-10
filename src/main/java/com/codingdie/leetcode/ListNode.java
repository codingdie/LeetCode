package com.codingdie.leetcode;

/**
 * Created by xupen on 2017/7/10.
 */
public class ListNode {
    public int val;
   public   ListNode next;

    public  ListNode(int x) {
        val = x;
    }
    void print() {
        ListNode t = this;
        StringBuffer stringBuffer = new StringBuffer();
        while (t != null) {
            stringBuffer.append(t.val + ",");
            t = t.next;
        }
        System.out.println(stringBuffer.substring(0, stringBuffer.length() - 1));
    }
}
