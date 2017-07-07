package com.codingdie.leetcode;

/**
 * Created by xupen on 2017/7/7.
 */
public class BalancedBinaryTree {
    boolean flag=true;
    public boolean isBalanced(TreeNode root) {
        height(root);
        return flag ;
    }
    public int height(TreeNode root) {
        if(root==null)return 0;
        int left = height(root.left);
        int right = height(root.right);
        if(Math.abs(left-right)>1)flag=false;
        return Math.max(left, right)+1 ;
    }


}
