package com.ite.leetcode.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Issam Tellissi
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        List<String> treeItems = new ArrayList<>();
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.push(this);
        while (!nodes.isEmpty()) {
            final TreeNode current = nodes.removeLast();
            treeItems.add(current != null ? String.valueOf(current.val) : "null");
            if (current != null && (current.left != null || current.right != null)) {
                nodes.push(current.left);
                nodes.push(current.right);
            }
        }
        return treeItems.toString();
    }
}
