package com.codingdie.leetcode.easy;

import com.codingdie.leetcode.TreeNode;

/**
 * Created by xupeng on 2017/7/12.
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root==null)return root;
        invertTree(root.left);
        invertTree(root.right);
        TreeNode tmp=root.left;
        root.left=root.right;
        root.right=tmp;
        return root;
    }
}
