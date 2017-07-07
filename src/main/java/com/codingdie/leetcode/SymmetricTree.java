package com.codingdie.leetcode;

import java.util.Map;

/**
 * Created by xupen on 2017/7/7.
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left,root.right);
    }
    public boolean isSymmetric(TreeNode left,TreeNode right) {
        if(left==null&&right==null)return true;
        if(left==null&&right!=null)return false;
        if(right==null&&left!=null)return false;
        return left.val==right.val&&isSymmetric(left.left,right.right)&&isSymmetric(left.right,right.left);
    }
}
