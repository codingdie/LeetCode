package com.codingdie.leetcode.medium;

import com.codingdie.leetcode.ListNode;

/**
 * Created by xupen on 2017/7/10.
 */
public class LinkedListCycleII {
    //找规律
    public ListNode detectCycle(ListNode head) {
        ListNode worker=head;
        ListNode runner=head;
        boolean flag=false;
        while (head!=null&&runner.next!=null&&runner.next.next!=null) {
            worker=worker.next;
            runner=runner.next.next;
            if(worker==runner){flag=true;break;}
        }
        if(flag){
            runner=head;
            while (worker!=null){
                if(worker==runner)break;

                worker=worker.next;
                runner=runner.next;
            }
        }

        return flag?worker:null;
    }
}
