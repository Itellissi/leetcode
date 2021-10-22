package com.ite.leetcode.y2021.m10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ite.leetcode.Solution;

/**
 * @author Issam Tellissi
 */
public class Solution22 implements Solution<String> {

    public String frequencySort(String s) {
        final Map<Character, StringBuilder> frequency = new HashMap<>();
        for (char c : s.toCharArray()) {
            StringBuilder old = frequency.computeIfAbsent(c, chr -> new StringBuilder());
            old.append(c);
        }
        List<StringBuilder> parts = new ArrayList<>(frequency.values());
        parts.sort(Comparator.comparing(StringBuilder::length).reversed());
        final StringBuilder result = new StringBuilder();
        for (StringBuilder part : parts) {
            result.append(part);
        }
        return result.toString();
    }
}
