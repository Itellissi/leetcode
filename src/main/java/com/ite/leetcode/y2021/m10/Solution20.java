package com.ite.leetcode.y2021.m10;

import com.ite.leetcode.Solution;

/**
 * @author Issam Tellissi
 */
public class Solution20 implements Solution<String> {

    public String reverseWords(String s) {
        final String[] parts = s.split(" ");
        final StringBuilder result = new StringBuilder();
        for (int i = parts.length - 1; i >= 0; i--) {
            String part = parts[i];
            if (!part.isEmpty()) {
                result.append(part).append(" ");
            }
        }
        return result.toString().trim();
    }

    @Override
    public String resultAsString(String actualResult) {
        return "\"" + actualResult + "\"";
    }
}
