package com.ite.leetcode.y2021.m10;

import com.ite.leetcode.Solution;

/**
 * @author Issam Tellissi
 */
public class Solution07 implements Solution<Boolean> {

    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        int idx = 0;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (chars[idx] == board[r][c] && lookup(board, r, c, visited, chars, idx + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean lookup(char[][] board, int r, int c, boolean[][] visited, char[] word, int idx) {
        if (idx == word.length) {
            return true;
        }
        visited[r][c] = true;
        if (r > 0 && !visited[r - 1][c] && board[r - 1][c] == word[idx] && lookup(board, r - 1, c, visited, word, idx + 1)) {
            return true;
        }
        if (c > 0 && !visited[r][c - 1] && board[r][c - 1] == word[idx] && lookup(board, r, c - 1, visited, word, idx + 1)) {
            return true;
        }
        if (r < board.length - 1 && !visited[r + 1][c] && board[r + 1][c] == word[idx] && lookup(board, r + 1, c, visited, word, idx + 1)) {
            return true;
        }
        if (c < board[0].length - 1 && !visited[r][c + 1] && board[r][c + 1] == word[idx] && lookup(board, r, c + 1, visited, word, idx + 1)) {
            return true;
        }
        visited[r][c] = false;
        return false;
    }
}
