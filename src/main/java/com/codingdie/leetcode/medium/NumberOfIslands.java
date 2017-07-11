package com.codingdie.leetcode.medium;

/**
 * Created by xupen on 2017/7/11.
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                char ch = grid[i][j];
                if (ch == '1') {
                    count++;
                    fillIsland(grid, i, j);
                }
            }
        }
        return count;
    }

    public void fillIsland(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length) return;
        if (j < 0 || j >= grid[i].length) return;
        if (grid[i][j] == '0') return;
        grid[i][j] = '0';
        fillIsland(grid, i + 1, j);
        fillIsland(grid, i - 1, j);
        fillIsland(grid, i, j + 1);
        fillIsland(grid, i, j - 1);
    }
}
