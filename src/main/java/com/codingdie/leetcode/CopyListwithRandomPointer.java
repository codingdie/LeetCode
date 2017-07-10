package com.codingdie.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xupen on 2017/7/7.
 */
public class CopyListwithRandomPointer {


    public static void main(String[] args) {
        RandomListNode node1 = new RandomListNode(-1);
        RandomListNode node2 = new RandomListNode(-2);
        RandomListNode node3 = new RandomListNode(-3);
        node1.next=node2;
        node2.next=node3;
        new CopyListwithRandomPointer().copyRandomList(node1).print();

    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        RandomListNode ptr = head;
        RandomListNode result = null;
        while (ptr != null) {
            RandomListNode newnode = new RandomListNode(ptr.label);
            if (result == null) {
                result = newnode;
            }
            newnode.next = ptr.next;
            ptr.next = newnode;
            ptr=newnode.next;
        }
        RandomListNode resultPtr = result;
        ptr=head;
        while (ptr!=null){
            if(ptr.random!=null){
                resultPtr.random=ptr.random.next;
            }else{
                resultPtr.random=null;
            }
            ptr=resultPtr.next;
            if(ptr!=null){
                resultPtr=ptr.next;
            }
        }
        resultPtr = result;
        ptr=head;
        while (ptr!=null){
            ptr.next=resultPtr.next;
            ptr=ptr.next;
            if(ptr!=null){
                resultPtr.next=ptr.next;
                resultPtr=resultPtr.next;
            }
        }
        return result;
    }




}
