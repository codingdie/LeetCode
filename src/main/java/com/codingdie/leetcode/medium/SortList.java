package com.codingdie.leetcode.medium;

import com.codingdie.leetcode.ListNode;

/**
 * Created by xupen on 2017/7/10.
 */
public class SortList {
    //归并排序
    public static void main(String[] args) {
        new SortList().sortList(ListNode.generate(20)).print();
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l11 = l1, l22 = l2;
        ListNode result = null, resultp = null;
        while (l11 != null || l22 != null) {
            ListNode listNode = null;
            if (l11 == null) {
                listNode = l22;
                l22 = l22.next;
            } else if (l22 == null) {
                listNode = l11;
                l11 = l11.next;
            } else {
                int i = l11.val, j = l22.val;
                listNode = i > j ? l22 : l11;
                if (i > j) {
                    l22 = l22.next;
                } else {
                    l11 = l11.next;
                }
            }
            if (result == null) {
                result = listNode;
                resultp = result;
            } else {
                resultp.next = listNode;
                resultp = resultp.next;
            }

        }
        return result;
    }

    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)return head;
        if(head.next.next==null){
            if(head.val>head.next.val){
                head.next.next=head;
                ListNode next = head.next;
                head.next=null;
                return next;
            }
        }
        ListNode behind = split(head);

        return mergeTwoLists(sortList(head), sortList(behind));
    }

    public ListNode split(ListNode head) {
        ListNode walker = head;
        ListNode runner = head;
        while (runner != null && runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
        }

        ListNode next = walker.next;
        walker.next=null;
        return next;
    }
}
