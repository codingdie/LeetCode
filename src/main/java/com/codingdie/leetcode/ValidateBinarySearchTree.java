package com.codingdie.leetcode;

import java.util.logging.Level;

/**
 * Created by xupen on 2017/7/7.
 */
public class ValidateBinarySearchTree {
    //利用中序遍历递增的特性
    Integer pre=null;
    public boolean isValidBST(TreeNode root) {
        if(root==null)return true ;
        if(isValidBST(root.left)==false) return false;
        if(pre!=null){
            if(root.val<=pre){
                return false;
            }
        }
        pre=root.val;
        if(isValidBST(root.right)==false) return false;
        return true;
    }




}
