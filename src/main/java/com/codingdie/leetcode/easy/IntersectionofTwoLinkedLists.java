package com.codingdie.leetcode.easy;

import com.codingdie.leetcode.ListNode;

/**
 * Created by xupen on 2017/7/11.
 */
public class IntersectionofTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1 = 0, l2 = 0;
        ListNode ptr1 = headA;
        ListNode ptr2 = headB;
        while (ptr1 != null || ptr2 != null) {
            if (ptr1 != null) {
                ptr1 = ptr1.next;
                l1++;
            }
            if (ptr2 != null) {
                ptr2 = ptr2.next;
                l2++;
            }
        }
        ptr1=l1>=l2?headA:headB;
        ptr2=l1>=l2?headB:headA;
        int i=Math.abs(l1-l2);
        while (i>0){
            ptr1=ptr1.next;
            i--;
        }
        while (ptr1!=null){
            if(ptr1==ptr2)return ptr1;
            ptr1=ptr1.next;
            ptr2=ptr2.next;
        }
        return null;
    }
}
