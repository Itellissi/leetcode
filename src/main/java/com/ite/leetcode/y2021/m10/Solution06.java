package com.ite.leetcode.y2021.m10;

import java.util.ArrayList;
import java.util.List;

import com.ite.leetcode.Solution;

/**
 * Constraints for this solution:
 * - time : O(n)
 * - space : constant
 *
 * @author Issam Tellissi
 */
public class Solution06 implements Solution<List<Integer>> {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int idx = 0;
        int temp;
        while (idx < nums.length) {
            temp = nums[idx];
            while (temp - 1 != idx) {
                // try permutation
                if (temp == nums[temp - 1]) {
                    break;
                } else {
                    nums[idx] = nums[temp - 1];
                    nums[temp - 1] = temp;
                    temp = nums[idx];
                }
            }
            idx++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                result.add(nums[i]);
            }
        }
        return result;
    }
}
