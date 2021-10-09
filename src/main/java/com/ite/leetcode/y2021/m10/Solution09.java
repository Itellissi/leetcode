package com.ite.leetcode.y2021.m10;

import java.util.ArrayList;
import java.util.List;

import com.ite.leetcode.Solution;

/**
 * @author Issam Tellissi
 */
public class Solution09 implements Solution<List<String>> {

    // cheating datasets with backtrack search, use Trie for more reliant implementation
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (containsWord(board, word)) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean containsWord(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word, word.length() - 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, String word, int idx) {
        char c = board[i][j];
        if (idx == 0) {
            return c == word.charAt(idx);
        }
        if (c != word.charAt(idx)) {
            return false;
        }
        board[i][j] = '#';
        boolean result = (i > 0 && dfs(board, i - 1, j, word, idx - 1))
              || (j > 0 && dfs(board, i, j - 1, word, idx - 1))
              || (i < board.length - 1 && dfs(board, i + 1, j, word, idx - 1))
              || (j < board[0].length - 1 && dfs(board, i, j + 1, word, idx - 1));
        board[i][j] = c;
        return result;
    }
}