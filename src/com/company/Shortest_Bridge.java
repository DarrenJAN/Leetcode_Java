package com.company;

public class Shortest_Bridge {
    int[][] dir = new int[][] {{1,0}, {0,1}, {-1,0}, {0, -1}};
    int result = Integer.MAX_VALUE;

    public int shortestBridge(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean first = false;

        for(int i = 0 ;i< row ;i++)
        {
            if(first)
                break;
            for(int j = 0; j< col;j++)
            {
                if(grid[i][j] ==  1)
                {
                    dfs_change(grid, i, j);
                    first = true;
                    break;
                }
            }
        }

        for(int i = 0 ;i< row ;i++)
        {
            for(int j = 0; j< col;j++)
            {
                if(grid[i][j] ==  2)
                {
                    dfs_find(grid, i, j,0);
                }
            }
        }

        return result;
    }

    public void dfs_change(int[][] grid, int row, int col)
    {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length)
            return;

        if(grid[row][col] == 1)
        {
            grid[row][col] = 2 ;
            for(int i = 0; i< 4 ;i++)
            {
                int x = row + dir[i][0];
                int y = col + dir[i][1];
                dfs_change(grid, x, y);
            }
        }
    }

    public void dfs_find(int[][] grid, int row, int col, int cur_step)
    {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length)
            return;

        if(grid[row][col] == 1)
        {
            result = Math.min(result, cur_step);
            return;
        }else if(grid[row][col] == 0 )
        {
            grid[row][col] = 2;
            for(int i = 0; i< 4 ;i++)
            {
                int x = row + dir[i][0];
                int y = col + dir[i][1];
                dfs_find(grid, x, y, cur_step+1);
            }
        }

    }
}
