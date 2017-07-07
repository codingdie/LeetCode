package com.codingdie.leetcode;

/**
 * Created by xupen on 2017/7/7.
 */
public class CopyListwithRandomPointer {

    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode result = new RandomListNode(head.label);
        RandomListNode resultPtr = result;
        RandomListNode ptr = head;

        while (ptr != null) {
            ptr = ptr.next;
            resultPtr.next = new RandomListNode(ptr.label);
            resultPtr = result.next;
        }
        resultPtr = result;
        ptr = head;
        while (resultPtr != null) {
            if (resultPtr.random != null) {
                RandomListNode ran = ptr.random;
                while (ptr != null) {

                }
            }
        }
        return result;
    }

    ;

    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }
}
