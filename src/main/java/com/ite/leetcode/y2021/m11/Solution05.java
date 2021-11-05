package com.ite.leetcode.y2021.m11;

import com.ite.leetcode.Solution;

/**
 * @author Issam Tellissi
 */
public class Solution05 implements Solution<Integer> {

    public int arrangeCoins(int n) {
        int estimate = (int) Math.floor(Math.sqrt((long) n * 2));
        return estimate * (estimate + 1) > 2 * n ? estimate - 1 : estimate;
    }
}
