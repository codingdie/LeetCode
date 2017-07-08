package com.codingdie.leetcode;

/**
 * Created by xupen on 2017/7/7.
 */
public class CopyListwithRandomPointer {


    public static void main(String[] args) {
        RandomListNode node1 = new RandomListNode(-1);
        node1.random=node1;
        new CopyListwithRandomPointer().copyRandomList(node1).print();

    }
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null)return null;
        RandomListNode result = null;
        RandomListNode resultPtr = null;
        RandomListNode ptr = head;

        while (ptr != null) {
            RandomListNode randomListNode = new RandomListNode(ptr.label);

            if(result==null) {
                resultPtr=randomListNode;
                result=randomListNode;
            }else{
                resultPtr.next = randomListNode;
                resultPtr = result.next;
            }
            ptr = ptr.next;
        }
        resultPtr = result;
        ptr = head;
        while (resultPtr != null) {
            if (ptr.random != null) {
                resultPtr.random=findRandom(ptr.random,head,result);
            }
            resultPtr = resultPtr.next;
            ptr = ptr.next;

        }
        return result;
    }

    public RandomListNode findRandom(RandomListNode obj, RandomListNode head, RandomListNode headcopy) {
        if(obj==null)return null;
        RandomListNode headptr=head;
        RandomListNode headcopyptr=headcopy;
        while (headptr!=null){
            System.out.println(head.label+":"+headcopy.label);
            if(head==obj){
                return headcopyptr;
            }
            headptr=headptr.next;
            headcopy=headcopy.next;
        }
        return null;
    }

}
