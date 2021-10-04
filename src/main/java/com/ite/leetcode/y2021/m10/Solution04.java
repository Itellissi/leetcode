package com.ite.leetcode.y2021.m10;

import com.ite.leetcode.Solution;

/**
 * @author Issam Tellissi
 */
public class Solution04 implements Solution<Integer> {

    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    perimeter += i > 0 && grid[i - 1][j] == 1 ? 0 : 1;
                    perimeter += i < grid.length - 1 && grid[i + 1][j] == 1 ? 0 : 1;
                    perimeter += j > 0 && grid[i][j - 1] == 1 ? 0 : 1;
                    perimeter += j < grid[i].length - 1 && grid[i][j + 1] == 1 ? 0 : 1;
                }
            }
        }
        return perimeter;
    }
}
