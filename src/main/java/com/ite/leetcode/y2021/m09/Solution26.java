package com.ite.leetcode.y2021.m09;

import com.ite.leetcode.Solution;

/**
 * @author Issam Tellissi
 */
public class Solution26 implements Solution<Integer> {

    public int movesToChessboard(int[][] board) {
        int countMatch = 1;
        int compare;
        for (int i = 1; i < board[0].length; i++) {
            if ((board[0][i] ^ board[0][0]) == 0) {
                countMatch++;
            }
        }
        if (Math.abs(board.length - 2 * countMatch) > 1) {
            return -1;
        }
        countMatch = 1;
        for (int i = 1; i < board.length; i++) {
            compare = board[i][0] ^ board[0][0];
            if (compare == 0) {
                countMatch++;
            }
            if (countMatch > board.length / 2) {

            }
            for (int j = 1; j < board[i].length; j++) {
                if (compare != (board[i][j] ^ board[0][j])) {
                    return -1;
                }
            }
        }
        if (Math.abs(board.length - 2 * countMatch) > 1) {
            return -1;
        }
        int[] column = new int[board.length];
        for (int i = 0; i < board.length; i++) {
            column[i] = board[i][0];
        }
        return countPermutations(board[0]) + countPermutations(column);
    }

    private int countPermutations(int[] arr) {
        int b = 0;
        int[] base = new int[arr.length];
        for (int i = 1; i < arr.length; i++) {
            base[i] = 1 - base[i - 1];
        }
        int r = 0;
        for (int i = 0; i < arr.length; i++) {
            if (base[i] == arr[i]) {
                r++;
            }
        }
        if (r % 2 == 1) {
            r = arr.length - r;
        } else if (arr.length % 2 == 0) {
            r = Math.min(r, arr.length - r);
        }
        return r / 2;
    }
}
