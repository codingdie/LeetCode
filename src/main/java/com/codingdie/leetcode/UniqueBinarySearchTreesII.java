package com.codingdie.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xupen on 2017/7/7.
 */
public class UniqueBinarySearchTreesII {
    public static void main(String[] args) {
        System.out.println(new UniqueBinarySearchTreesII().generateTrees(3).size());

    }

    public List<TreeNode> generateTrees(int n) {
        return generateTrees(0, n - 1, n);
    }

    public List<TreeNode> generateTrees(int left, int right, int n) {
        List<TreeNode> result = new ArrayList<>();
        if (left < 0 || right > n) return result;
        if (left == right) {
            result.add(new TreeNode(left + 1));
        } else {
            for (int i = left; i <= right; i++) {
                List<TreeNode> lefts = generateTrees(left, i - 1, n);
                List<TreeNode> rights = generateTrees(i + 1, right, n);
                if (i == left) {
                    for (TreeNode node : rights) {
                        TreeNode treeNode = new TreeNode(i + 1);
                        result.add(treeNode);
                        treeNode.right = node;
                    }
                } else if (i == right) {
                    for (TreeNode node : lefts) {
                        TreeNode treeNode = new TreeNode(i + 1);
                        result.add(treeNode);
                        treeNode.left = node;
                    }
                } else {
                    for (TreeNode leftnode : lefts) {
                        for (TreeNode rightnode : rights) {
                            TreeNode treeNode = new TreeNode(i + 1);
                            result.add(treeNode);
                            treeNode.left = leftnode;
                            treeNode.right = rightnode;
                        }
                    }
                }
            }
        }
        return result;
    }

}
