package com.ite.leetcode.y2021.m10;

import com.ite.leetcode.Solution;
import com.ite.leetcode.model.TreeNode;

/**
 * @author Issam Tellissi
 */
public class Solution13 implements Solution<TreeNode> {

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;
        TreeNode currentNode;
        for (int i : preorder) {
            if (root == null) {
                root = new TreeNode(i);
            } else {
                currentNode = root;
                boolean found = false;
                while (!found) {
                    if (currentNode.val > i) {
                        if (currentNode.left == null) {
                            currentNode.left = new TreeNode(i);
                            found = true;
                        } else {
                            currentNode = currentNode.left;
                        }
                    } else {
                        if (currentNode.right == null) {
                            currentNode.right = new TreeNode(i);
                            found = true;
                        } else {
                            currentNode = currentNode.right;
                        }
                    }
                }
            }
        }
        return root;
    }
}
