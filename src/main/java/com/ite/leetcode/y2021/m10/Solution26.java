package com.ite.leetcode.y2021.m10;

import com.ite.leetcode.Solution;
import com.ite.leetcode.model.TreeNode;

/**
 * @author Issam Tellissi
 */
public class Solution26 implements Solution<TreeNode> {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode oldLeft = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(oldLeft);
        return root;
    }
}
