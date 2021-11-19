package com.ite.leetcode.y2021.m11;

import com.ite.leetcode.Solution;

/**
 * @author Issam Tellissi
 */
public class Solution19 implements Solution<Integer> {

    public int hammingDistance(int x, int y) {
        String s = Integer.toBinaryString(x ^ y);
        int c = 0;
        for (char chr : s.toCharArray()) {
            if (chr == '1') {
                c++;
            }
        }
        return c;
    }
}
