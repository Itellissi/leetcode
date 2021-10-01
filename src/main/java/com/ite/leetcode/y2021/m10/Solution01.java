package com.ite.leetcode.y2021.m10;

import com.ite.leetcode.Solution;

/**
 * @author Issam Tellissi
 */
public class Solution01 implements Solution<Integer> {

    public int longestCommonSubsequence(String text1, String text2) {
        return dp(text1.toCharArray(), text2.toCharArray(), new Integer[text1.length()][text2.length()], text1.length() - 1, text2.length() - 1);
    }

    private int dp(char[] text1, char[] text2, Integer[][] cache, int i, int j) {
        if (cache[i][j] != null) {
            return cache[i][j];
        }
        if (i == 0 && j == 0) {
            cache[i][j] = text1[0] == text2[0] ? 1 : 0;
        } else if (i == 0) {
            cache[i][j] = Math.max(text1[i] == text2[j] ? 1 : 0, dp(text1, text2, cache, i, j - 1));
        } else if (j == 0) {
            cache[i][j] = Math.max(text1[i] == text2[j] ? 1 : 0, dp(text1, text2, cache, i - 1, j));
        } else {
            cache[i][j] = text1[i] == text2[j] ?
                  dp(text1, text2, cache, i - 1, j - 1) + 1 :
                  Math.max(dp(text1, text2, cache, i - 1, j), dp(text1, text2, cache, i, j - 1));
        }

        return cache[i][j];
    }
}
