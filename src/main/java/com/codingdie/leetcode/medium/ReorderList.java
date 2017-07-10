package com.codingdie.leetcode.medium;

import com.codingdie.leetcode.ListNode;

/**
 * Created by xupen on 2017/7/10.
 */
public class ReorderList {
    public static void main(String[] args) {
        ListNode generate = ListNode.generate(4);
        new ReorderList().reorderList(generate);
        generate.print();
    }
    //快慢指针

    public void reorderList(ListNode head) {
        ListNode walker = head;
        ListNode runner = head;
        while (runner != null && runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
        }
        ListNode behind = walker.next;
        walker.next = null;
        behind = reverseList(behind);
        walker = head;
        while (walker != null&&behind!=null) {
            ListNode next = walker.next;
            ListNode nextb = behind.next;
            walker.next = behind;
            behind.next = next;
            walker = next;
            behind = nextb;
        }
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
