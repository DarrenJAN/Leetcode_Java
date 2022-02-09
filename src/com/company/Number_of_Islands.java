package com.company;

public class Number_of_Islands {
    int result = 0;
    int[][] dir = new int[][] {{1,0}, {0,1}, {-1, 0}, {0,-1}};

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        for(int i = 0;i< row; i++)
        {
            for(int j = 0;j< col; j++)
            {
                if(grid[i][j] == '1')
                {
                    result++;
                    dfs(grid, i, j);
                }
            }
        }

        return result;
    }

    public void dfs(char[][] grid, int row, int col)
    {
        if( row< 0 || col < 0 || row >= grid.length || col >= grid[0].length)
        {
            return;
        }

        if(grid[row][col] == '0')
            return;

        grid[row][col] = '0';
        for(int i = 0;i<4;i++)
        {
            int x = row + dir[i][0];
            int y = col + dir[i][1];

            dfs(grid, x ,y);
        }
    }
}
