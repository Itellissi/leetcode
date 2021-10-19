package com.ite.leetcode.y2021.m10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.ite.leetcode.Solution;

/**
 * @author Issam Tellissi
 */
public class Solution19 implements Solution<int[]> {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        final Map<Integer, Integer> indexes = new HashMap<>(nums2.length, 1);
        for (int i = 0; i < nums2.length; i++) {
            indexes.put(nums2[i], i);
        }
        for (int i = 0; i < nums1.length; i++) {
            result[i] = -1;
            int current = nums1[i];
            for (int j = indexes.get(current) + 1; j < nums2.length; j++) {
                if (current < nums2[j]) {
                    result[i] = nums2[j];
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public String resultAsString(int[] actualResult) {
        return Arrays.toString(actualResult);
    }
}
