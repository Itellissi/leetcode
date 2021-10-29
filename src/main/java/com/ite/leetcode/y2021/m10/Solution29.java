package com.ite.leetcode.y2021.m10;

import java.util.ArrayList;
import java.util.List;

import com.ite.leetcode.Solution;

/**
 * @author Issam Tellissi
 */
public class Solution29 implements Solution<Integer> {

    private static final int[][] directions = new int[][]{
          {-1, 0},
          {0, -1},
          {1, 0},
          {0, 1}
    };

    public int orangesRotting(int[][] grid) {
        List<int[]> rottenOranges = new ArrayList<>();
        int countFresh = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                switch (grid[i][j]) {
                    case 2:
                        rottenOranges.add(new int[]{i, j});
                        break;
                    case 1:
                        countFresh++;
                        break;
                    default:
                        break;
                }
            }
        }
        int iteration = 0;
        List<int[]> nextRotten;
        while (!rottenOranges.isEmpty() && countFresh > 0) {
            nextRotten = new ArrayList<>();
            for (int[] rottenOrange : rottenOranges) {
                for (int[] direction : directions) {
                    int nextI = direction[0] + rottenOrange[0];
                    int nextJ = direction[1] + rottenOrange[1];
                    if (nextI < rows && nextI >= 0 && nextJ < cols && nextJ >= 0 && grid[nextI][nextJ] == 1) {
                        nextRotten.add(new int[]{nextI, nextJ});
                        grid[nextI][nextJ] = 2;
                        countFresh--;
                    }
                }
            }
            rottenOranges = nextRotten;
            iteration++;
        }
        return countFresh == 0 ? iteration : -1;
    }
}
