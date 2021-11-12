package com.ite.leetcode.y2021.m11;

import com.ite.leetcode.Solution;

/**
 * @author Issam Tellissi
 */
public class Solution11 implements Solution<Integer> {

    public int minStartValue(int[] nums) {
        int min = Integer.MAX_VALUE, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            min = Math.min(min, sum);
        }

        return min > 0 ? 1 : 1 - min;
    }
}
