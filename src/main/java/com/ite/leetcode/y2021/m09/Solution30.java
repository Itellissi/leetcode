package com.ite.leetcode.y2021.m09;

import java.util.Arrays;

import com.ite.leetcode.Solution;

/**
 * @author Issam Tellissi
 */
public class Solution30 implements Solution<Boolean> {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        sum /= k;
        int[] tempSums = new int[k];
        Arrays.sort(nums);
        return hasValidCombination(nums, nums.length - 1, sum, tempSums);
    }

    private boolean hasValidCombination(int[] nums, int idx, int target, int[] tempSums) {
        if (idx < 0) {
            for (int sum : tempSums) {
                if (sum != target) {
                    return false;
                }
            }
            return true;
        }
        int curr = nums[idx];
        for (int i = 0; i < tempSums.length; i++) {
            if (tempSums[i] + curr <= target) {
                tempSums[i] += curr;
                if (hasValidCombination(nums, idx - 1, target, tempSums)) {
                    return true;
                }
                tempSums[i] -= curr;
            }
        }
        return false;
    }
}
