package com.ite.leetcode.y2021.m11;

import com.ite.leetcode.Solution;
import com.ite.leetcode.model.TreeNode;

/**
 * @author Issam Tellissi
 */
public class Solution04 implements Solution<Integer> {

    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, false);
    }

    public int helper(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return isLeft ? root.val : 0;
        } else {
            return helper(root.left, true) + helper(root.right, false);
        }
    }
}
