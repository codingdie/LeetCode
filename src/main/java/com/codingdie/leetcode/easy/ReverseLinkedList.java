package com.codingdie.leetcode.easy;

import com.codingdie.leetcode.ListNode;

/**
 * Created by xupen on 2017/7/10.
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        new ReverseLinkedList().reverseList(ListNode.generate(10)).print();
    }

    public ListNode reverseList(ListNode head) {
        ListNode result = null;
        ListNode ptr = head;
        while (ptr != null) {
            ListNode next = ptr.next;
            ptr.next = result;
            result = ptr;
            ptr = next;
        }
        return result;
    }
}
