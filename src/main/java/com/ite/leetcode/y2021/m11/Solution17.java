package com.ite.leetcode.y2021.m11;

import com.ite.leetcode.Solution;

/**
 * @author Issam Tellissi
 */
public class Solution17 implements Solution<Integer> {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] += i > 0 ? dp[i - 1][j] : 0;
                dp[i][j] += j > 0 ? dp[i][j - 1] : 0;
            }
        }
        return dp[m - 1][n - 1];
    }
}
