package com.ite.leetcode.y2021.m09;

import java.util.Arrays;

import com.ite.leetcode.Solution;

/**
 * @author Issam Tellissi
 */
public class Solution28 implements Solution<int[]> {

    public int[] sortArrayByParityII(int[] nums) {
        int evenIdx = 0;
        int oddIdx = 1;
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (current % 2 == 0) {
                result[evenIdx] = current;
                evenIdx += 2;
            } else {
                result[oddIdx] = current;
                oddIdx += 2;
            }
        }
        return result;
    }

    @Override
    public String resultAsString(int[] actualResult) {
        return Arrays.toString(actualResult);
    }
}
