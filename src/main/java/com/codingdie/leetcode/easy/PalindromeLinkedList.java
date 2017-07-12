package com.codingdie.leetcode.easy;

import com.codingdie.leetcode.ListNode;

/**
 * Created by xupeng on 2017/7/12.
 */
public class PalindromeLinkedList {
    //快慢指针 翻转链表 可以写成一个循环
    public boolean isPalindrome(ListNode head) {
        if(head==null)return true;
        ListNode slow=head;
        ListNode fast=head;

        while (fast!=null&&fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode af=slow.next;
        ListNode be= slow.next=null;
        reverseList(head);
        if(fast.next==null){
            be=be.next;
        }
        while (af!=null){
            if(af.val!=be.val)return false;
            be=be.next;
            af=af.next;
        }
        return true;

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
