package com.ite.leetcode.y2021.m11;

import com.ite.leetcode.Solution;

/**
 * @author Issam Tellissi
 */
public class Solution02 implements Solution<Integer> {

    public int uniquePathsIII(int[][] grid) {
        int steps = 0;
        int x = 0, y = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    steps++;
                } else if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                }
            }
        }
        return dfs(grid, x, y, steps);
    }

    private int dfs(int[][] grid, int x, int y, int steps) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == -1) {
            return 0;
        }
        if (grid[x][y] == 2) {
            return steps == -1 ? 1 : 0;
        }
        grid[x][y] = -1;
        steps--;
        int totalPaths = dfs(grid, x + 1, y, steps);
        totalPaths += dfs(grid, x, y + 1, steps);
        totalPaths += dfs(grid, x - 1, y, steps);
        totalPaths += dfs(grid, x, y - 1, steps);
        grid[x][y] = 0;
        steps++;
        return totalPaths;
    }
}
