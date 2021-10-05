package com.ite.leetcode.y2021.m10;

import java.util.HashMap;
import java.util.Map;

import com.ite.leetcode.Solution;

/**
 * @author Issam Tellissi
 */
public class Solution05 implements Solution<Integer> {

    public int climbStairs(int n) {
        return dp(n, new HashMap<>());
    }

    public int dp(int n, Map<Integer, Integer> cache) {
        Integer cached = cache.get(n);
        if (cached != null) {
            return cached;
        }
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        }
        int result = dp(n - 2, cache) + dp(n - 1, cache);
        cache.put(n, result);
        return result;
    }
}
