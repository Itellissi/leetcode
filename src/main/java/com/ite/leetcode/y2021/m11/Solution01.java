package com.ite.leetcode.y2021.m11;

import java.util.ArrayList;
import java.util.List;

import com.ite.leetcode.Solution;

/**
 * @author Issam Tellissi
 */
public class Solution01 implements Solution<String> {

    private static final int[][] directions = new int[][]{new int[]{-1, 0}, new int[]{1, 0}, new int[]{0, -1}, new int[]{0, 1}};

    public String test(char[][] board) {
        solve(board);
        final StringBuilder result = new StringBuilder(System.lineSeparator());
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                result.append(board[i][j]);
            }
            result.append(System.lineSeparator());
        }
        return result.toString();
    }

    public void solve(char[][] board) {
        if (board.length > 1 && board[0].length > 1) {
            boolean[][] visited = new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == 'O' && !visited[i][j]) {
                        List<int[]> readyToCapture = new ArrayList<>();
                        readyToCapture.add(new int[]{i, j});
                        visited[i][j] = true;
                        boolean isEdge = i == 0 || j == 0 || i == board.length - 1 || j == board[i].length - 1;
                        if (!isEdge(board, i, j, visited, readyToCapture, isEdge)) {
                            for (int[] coordintes : readyToCapture) {
                                board[coordintes[0]][coordintes[1]] = 'X';
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean isEdge(char[][] board, int i, int j, boolean[][] visited, List<int[]> readyToCapture, boolean edge) {
        boolean isEdge = edge;
        for (int[] d : directions) {
            int newI = i + d[0];
            int newJ = j + d[1];
            if (newI >= 0 && newI < board.length && newJ >= 0 && newJ < board[newI].length) {
                if (board[newI][newJ] == 'O' && !visited[newI][newJ]) {
                    visited[newI][newJ] = true;
                    if (!isEdge) {
                        readyToCapture.add(new int[]{newI, newJ});
                    }
                    isEdge = isEdge(board, newI, newJ, visited, readyToCapture, isEdge) || isEdge;
                }
            } else {
                isEdge = true;
            }
        }
        return isEdge;
    }
}
