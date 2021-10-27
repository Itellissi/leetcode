package com.ite.leetcode.y2021.m10;

import java.util.Arrays;

import com.ite.leetcode.Solution;

/**
 * @author Issam Tellissi
 */
public class Solution27 implements Solution<int[]> {

    @Override
    public String resultAsString(int[] actualResult) {
        return Arrays.toString(actualResult);
    }

    public int[] test(int[] nums) {
        sortColors(nums);
        return nums;
    }

    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int temp;
        for (int i = 0; i <= end; ) {
            if (nums[i] == 2) {
                temp = nums[end];
                nums[end] = nums[i];
                nums[i] = temp;
                end--;
            }
            if (nums[i] == 0) {
                temp = nums[start];
                nums[start] = nums[i];
                nums[i] = temp;
                start++;
            }
            if (nums[i] != 2) {
                i++;
            }
        }
    }
}
