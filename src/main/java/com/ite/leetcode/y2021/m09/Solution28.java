package com.ite.leetcode.y2021.m09;

import java.util.Arrays;

import com.ite.leetcode.Solution;

/**
 * @author Issam Tellissi
 */
public class Solution28 implements Solution<int[]> {

    public int[] sortArrayByParityII(int[] nums) {
        int odd = 1;
        int temp;
        for (int even = 0; even < nums.length; even += 2) {
            if (nums[even] % 2 != 0) {
                // check odd that are not in place
                while (nums[odd] % 2 == 1) {
                    odd += 2;
                }
                temp = nums[even];
                nums[even] = nums[odd];
                nums[odd] = temp;
            }
        }
        return nums;
    }

    @Override
    public String resultAsString(int[] actualResult) {
        return Arrays.toString(actualResult);
    }
}
