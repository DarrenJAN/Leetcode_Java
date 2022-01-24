package com.company;

public class Max_area_of_Island {
    public int maxAreaOfIsland(int[][] grid) {
        int row  = grid.length;
        int col = grid[0].length;
        int result = 0;

        for(int i = 0;i<row;i++)
        {
            for(int j = 0;j< col;j++)
            {
                if(grid[i][j] == 1 )
                {
                    result = Math.max(result, dfs(grid, i, j));
                }
            }
        }

        return result;
    }

    int dfs(int[][] grid, int r, int c)
    {
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length)
        {
            return 0;
        }

        if(grid[r][c] == 0)
        {
            return 0;
        }else
        {
            grid[r][c] = 0;
            return 1 + dfs(grid, r+1, c) + dfs(grid, r-1, c) + dfs(grid, r, c+1) + dfs(grid, r, c-1);
        }
    }
}
