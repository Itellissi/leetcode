package com.ite.leetcode.y2021.m11;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.ite.leetcode.Solution;

/**
 * @author Issam Tellissi
 */
public class Solution06 implements Solution<int[]> {

    @Override
    public String resultAsString(int[] actualResult) {
        return "" + actualResult[0] + "\t" + actualResult[1];
    }

    public int[] singleNumber(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        for (int num : nums) {
            if (numbers.contains(num)) {
                numbers.remove(num);
            } else {
                numbers.add(num);
            }
        }
        Iterator<Integer> iterator = numbers.iterator();
        return new int[]{iterator.next(), iterator.next()};
    }
}
