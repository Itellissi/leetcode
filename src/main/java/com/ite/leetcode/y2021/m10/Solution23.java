package com.ite.leetcode.y2021.m10;

import com.ite.leetcode.Solution;

/**
 * @author Issam Tellissi
 */
public class Solution23 implements Solution<Integer> {

    public int findMin(int[] nums) {
        int i = 0;
        int last = nums[nums.length - 1];
        while (i < nums.length && nums[i] >= last) {
            i++;
        }
        return nums[Math.min(nums.length - 1, i)];
    }
}
