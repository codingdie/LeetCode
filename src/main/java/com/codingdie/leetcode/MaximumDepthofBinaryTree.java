package com.codingdie.leetcode;

/**
 * Created by xupen on 2017/7/7.
 */
public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root==null)return 0;
        int i = maxDepth(root.left);
        int j = maxDepth(root.right);
        return 1+( i>j?i:j);
    }
}
