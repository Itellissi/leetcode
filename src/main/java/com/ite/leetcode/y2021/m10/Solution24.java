package com.ite.leetcode.y2021.m10;

import com.ite.leetcode.Solution;
import com.ite.leetcode.model.TreeNode;

/**
 * @author Issam Tellissi
 */
public class Solution24 implements Solution<Integer> {

    public int countNodes(TreeNode root) {
        return root == null ? 0 : 1 + countNodes(root.left) + countNodes(root.right);
    }
}
