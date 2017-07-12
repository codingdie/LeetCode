package com.codingdie.leetcode.easy;

import com.codingdie.leetcode.TreeNode;

/**
 * Created by xupeng on 2017/7/12.
 */
public class PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        return pathSum(root,sum,false);
    }
    public int pathSum(TreeNode root, int sum,boolean flag) {
        if(sum==0&&flag)return 1;
        if(root==null)return 0;
        return pathSumRe(root,sum,false)+pathSum(root.left,sum,false)+pathSum(root.right,sum,false);
    }


    public int pathSumRe(TreeNode root, int sum,boolean flag) {
        if(root==null)return 0;
        if(sum==root.val)return  pathSumRe(root.left,0,false)+1+pathSumRe(root.right,0,false);
        int total=0;
        if(root.left!=null){
            total+=pathSumRe(root.left,sum-root.val,true);
        }
        if(root.right!=null){
            total+=pathSumRe(root.right,sum-root.val,true);
        }
        return total;
    }
}
