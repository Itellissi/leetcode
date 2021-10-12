package com.ite.leetcode.y2021.m10;

import com.ite.leetcode.Solution;
import com.ite.leetcode.model.TreeNode;

/**
 * @author Issam Tellissi
 */
public class Solution11 implements Solution<Integer> {

    public int diameterOfBinaryTree(TreeNode root) {
        return recursiveCost(root).weight;
    }

    public NodeCost recursiveCost(TreeNode node) {
        NodeCost nodeCost = new NodeCost();
        if (node != null) {
            NodeCost leftChildCost = recursiveCost(node.left);
            NodeCost rightChildCost = recursiveCost(node.right);
            nodeCost.level = Math.max(leftChildCost.level + 1, rightChildCost.level + 1);
            nodeCost.weight = Math.max(
                  leftChildCost.level + rightChildCost.level,
                  Math.max(leftChildCost.weight, rightChildCost.weight)
            );
        }
        return nodeCost;
    }

    class NodeCost {
        int level = 0;
        int weight = 0;
    }
}
