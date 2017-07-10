package com.codingdie.leetcode;

/**
 * Created by xupen on 2017/7/10.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode generate(int total) {
        ListNode result = null;
        ListNode ptr = null;
        for (int i = 0; i < total; i++) {
            ListNode node1 = new ListNode(i + 1);
            if (result == null) result = node1;
            else ptr.next = node1;
            ptr = node1;
        }
        return result;
    }

    public void print() {
        ListNode t = this;
        StringBuffer stringBuffer = new StringBuffer();
        while (t != null) {
            stringBuffer.append(t.val + ",");
            t = t.next;
        }
        System.out.println(stringBuffer.substring(0, stringBuffer.length() - 1));
    }
}
