package com.codingdie.leetcode.easy;

import com.codingdie.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xupen on 2017/7/10.
 */
public class LinkedListCycle {
    //快慢指针
    public boolean hasCycle(ListNode head) {
        ListNode worker=head;
        ListNode runner=head;
        while (head!=null&&runner.next!=null&&runner.next.next!=null) {
            worker=worker.next;
            runner=runner.next.next;
            if(worker==runner)return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode node=new ListNode(1);
        System.out.println(new LinkedListCycle().hasCycle(node));
    }
}
