package com.codingdie.leetcode;

/*
  Created by xupen on 2017/7/6.
 */
public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n){
            return head;
        }
        ListNode result=head;
        int i=1;
        ListNode rhead=null;
        ListNode begin=null;
        ListNode end=null;
        ListNode rEnd=null;

        ListNode pre=null;
        while (result!=null){
            ListNode next = result.next;
            if(i==m){
                rEnd=result;
                if(pre!=null){
                    begin=pre;
                }
            }
            pre=result;
            if(m<=i&&i<=n){
                result.next =rhead;
                rhead=result;
            }
            if(i==n){
                end= next;
                break;
            }
            i++;
            result= next;
        }
        rEnd.next=end;
        if(m==1){
            return rhead;
        }
        else{
            begin.next=rhead;
            return  head;
        }
    }

    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        node1.next=node2;
        ListNode node3=new ListNode(3);
        node2.next=node3;
        new ReverseLinkedListII().reverseBetween(node1,2,3).print();
    }
}
