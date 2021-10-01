package com.ite.leetcode.y2021.m10;

import com.ite.leetcode.Solution;

/**
 * @author Issam Tellissi
 */
public class Solution01 implements Solution<Integer> {

    public int longestCommonSubsequence(String text1, String text2) {
        char[] text1Chars = text1.toCharArray();
        char[] text2Chars = text2.toCharArray();
        int[][] dp = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1Chars.length; i++) {
            for (int j = 0; j < text2Chars.length; j++) {
                if (text1Chars[i] == text2Chars[j]) {
                    dp[i][j] = 1 + (i > 0 && j > 0 ? dp[i - 1][j - 1] : 0);
                } else {
                    dp[i][j] = Math.max(
                          i > 0 ? dp[i - 1][j] : 0,
                          j > 0 ? dp[i][j - 1] : 0
                    );
                }
            }
        }
        return dp[text1.length() - 1][text2.length() - 1];
    }
}
