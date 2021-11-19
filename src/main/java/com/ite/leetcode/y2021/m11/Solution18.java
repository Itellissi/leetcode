package com.ite.leetcode.y2021.m11;

import java.util.ArrayList;
import java.util.List;

import com.ite.leetcode.Solution;

/**
 * @author Issam Tellissi
 */
public class Solution18 implements Solution<List<Integer>> {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int[] count = new int[nums.length];
        for (int i : nums) {
            count[i - 1] += 1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (count[i] == 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
