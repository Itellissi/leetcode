package com.ite.leetcode.y2021.m10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.ite.leetcode.Solution;

/**
 * @author Issam Tellissi
 */
public class Solution28 implements Solution<List<List<Integer>>> {

    @Override
    public String resultAsString(List<List<Integer>> actualResult) {
        return "[" + actualResult.stream()
              .map(Object::toString)
              .collect(Collectors.joining(",")) + "]";
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // sort the items
        Arrays.sort(nums);
        if (nums.length < 3 || nums[0] > 0 || nums[nums.length - 1] < 0) {
            // return empty list if first item is positive (means every thing is positive), or last is negative meaning
            // everything is negative
            return result;
        }
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                // skip, will return duplicates
                continue;
            }
            int s = i + 1; // start
            int e = nums.length - 1; // end
            while (s < e && nums[e] >= 0) {
                int sum = nums[s] + nums[e] + nums[i];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[s], nums[e]));
                    while (s < e && nums[s] == nums[s + 1]) {
                        // skip duplicates
                        s++;
                    }
                    while (s < e && nums[e] == nums[e - 1]) {
                        // skip duplicates
                        e--;
                    }
                    s++;
                    e--;
                } else if (sum > 0) {
                    e--;
                } else {
                    s++;
                }
            }
        }
        return result;
    }
}
