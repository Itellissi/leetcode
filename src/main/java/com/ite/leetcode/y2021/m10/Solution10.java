package com.ite.leetcode.y2021.m10;

import com.ite.leetcode.Solution;

/**
 * @author Issam Tellissi
 */
public class Solution10 implements Solution<Integer> {

    public int rangeBitwiseAnd(int m, int n) {
        int diff = n - m;
        int count = 0;
        while (diff > 0) {
            count++;
            diff /= 2;
        }
        return n & m & (-1 << count);
    }
}
