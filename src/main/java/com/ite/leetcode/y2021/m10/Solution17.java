package com.ite.leetcode.y2021.m10;

import java.util.HashMap;

import com.ite.leetcode.Solution;
import com.ite.leetcode.model.TreeNode;

/**
 * @author Issam Tellissi
 */
public class Solution17 implements Solution<Integer> {

    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        cache.put(0, 1);
        return helper(root, targetSum, 0, cache);
    }

    private int helper(TreeNode node, int targetSum, int cumSum,
                       HashMap<Integer, Integer> cache) {
        if (node == null) {
            return 0;
        }
        int cumulatedSum = node.val + cumSum;
        int delta = cumulatedSum - targetSum;
        int result = cache.getOrDefault(delta, 0);
        cache.put(cumulatedSum, cache.getOrDefault(cumulatedSum, 0) + 1);
        result += helper(node.left, targetSum, cumulatedSum, cache);
        result += helper(node.right, targetSum, cumulatedSum, cache);
        cache.put(cumulatedSum, cache.get(cumulatedSum) - 1);
        return result;
    }
}
