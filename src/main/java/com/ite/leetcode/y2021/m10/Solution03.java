package com.ite.leetcode.y2021.m10;

import com.ite.leetcode.Solution;

/**
 * @author Issam Tellissi
 */
public class Solution03 implements Solution<Boolean> {

    public boolean canJump(int[] nums) {
        int maxJump = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            maxJump--;
            if (i + maxJump >= nums.length - 1) {
                return true;
            } else if (nums[i] != 0) {
                maxJump = Math.max(maxJump, nums[i]);
            } else if (maxJump == 0) {
                return false;
            }
        }
        return true;
    }
}
