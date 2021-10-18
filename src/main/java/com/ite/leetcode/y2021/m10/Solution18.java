package com.ite.leetcode.y2021.m10;

import com.ite.leetcode.Solution;
import com.ite.leetcode.model.TreeNode;

/**
 * @author Issam Tellissi
 */
public class Solution18 implements Solution<Boolean> {

    public boolean isCousins(TreeNode root, int x, int y) {
        NodeInfo xInfo = findNode(null, root, x, 0);
        NodeInfo yInfo = findNode(null, root, y, 0);
        return xInfo != null
              && yInfo != null
              && xInfo.level == yInfo.level
              && xInfo.parent != yInfo.parent;
    }

    private NodeInfo findNode(TreeNode parent, TreeNode current, int x, int currentLevel) {
        if (current.val == x) {
            return new NodeInfo(current, parent, currentLevel);
        }
        NodeInfo candidate = null;
        if (current.right != null) {
            candidate = findNode(current, current.right, x, currentLevel + 1);
        }
        return candidate == null && current.left != null ?
              findNode(current, current.left, x, currentLevel + 1)
              : candidate;
    }

    class NodeInfo {
        final TreeNode parent;
        final TreeNode node;
        final int level;

        private NodeInfo(TreeNode node, TreeNode parent, int level) {
            this.level = level;
            this.node = node;
            this.parent = parent;
        }
    }
}
