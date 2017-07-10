package com.codingdie.leetcode.easy;

import com.codingdie.leetcode.ListNode;

/**
 * Created by xupen on 2017/7/10.
 */
public class MergeTwoSortedLists {
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

}
