package com.ite.leetcode.y2021.m11;

import java.util.ArrayList;
import java.util.List;

import com.ite.leetcode.Solution;

/**
 * @author Issam Tellissi
 */
public class Solution09 implements Solution<List<Integer>> {

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        int[] puzzleMasks = new int[puzzles.length];
        int[] firstWordMasks = new int[puzzles.length];
        for (int i = 0; i < puzzles.length; i++) {
            puzzleMasks[i] = calculateMask(puzzles[i]);
            firstWordMasks[i] = 1 << (puzzles[i].charAt(0) - 'a');
        }

        int[] wordMasks = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            wordMasks[i] = calculateMask(words[i]);
        }
        final List<Integer> result = new ArrayList<>(puzzles.length);
        int countMatch;
        int i = 0;
        for (int puzzleMask : puzzleMasks) {
            countMatch = 0;
            int firstWordMask = firstWordMasks[i++];
            for (int wordMask : wordMasks) {
                if ((firstWordMask & wordMask) > 0 && (puzzleMask | wordMask) == puzzleMask) {
                    countMatch++;
                }
            }
            result.add(countMatch);
        }
        return result;
    }

    private int calculateMask(String word) {
        int mask = 0;
        for (char c : word.toCharArray()) {
            mask |= 1 << (c - 'a');
        }
        return mask;
    }
}
