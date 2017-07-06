package com.codingdie.leetcode;

/**
 * Created by xupen on 2017/7/6.
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null){
            return true;
        }else{

        }if ((p == null && q != null) || (q == null && p != null)) {
            return false;
        }else{
            return isSameTree(p.left, q.left)&&isSameTree(p.right, q.right)&&p.val==q.val;
        }

    }
}
