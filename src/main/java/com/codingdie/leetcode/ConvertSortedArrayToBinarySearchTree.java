package com.codingdie.leetcode;

/**
 * Created by xupen on 2017/7/7.
 */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0)return null;
        return sortedArrayToBST(nums,0,nums.length-1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int begin, int end) {
        if(begin<0||end>=nums.length||end>begin){
            return null;
        }
        if (begin==end)return new TreeNode(nums[begin]);
        int mid = (begin+end)/2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = sortedArrayToBST(nums, begin, mid - 1);
        treeNode.right = sortedArrayToBST(nums, mid + 1, end);
        return treeNode;
    }

}
