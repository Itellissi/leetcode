package com.ite.leetcode.y2021.m11;

import com.ite.leetcode.Solution;
import com.ite.leetcode.model.TreeNode;

/**
 * @author Issam Tellissi
 */
public class Solution03 implements Solution<Integer> {

    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        int currentVal = val * 10 + root.val;
        if (root.left != null || root.right != null) {
            return helper(root.left, currentVal) + helper(root.right, currentVal);
        } else {
            // leaf
            return currentVal;
        }
    }
}
