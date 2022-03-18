package com.company;

public class Number_of_Islands {
    int result = 0;
    int[][] dir = new int[][] {{0,1}, {0,-1}, {1,0} , {-1,0}};
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        for(int i = 0;i<row;i++)
        {
            for(int j = 0;j< col;j++)
            {
                if (grid[i][j] == '1')
                {
                    dfs(grid, i, j,row, col);
                    result ++;
                }
            }
        }
        return  result;
    }

    public void dfs(char[][] grid, int x, int y, int row, int col )
    {
        grid[x][y] = '0';

        for(int i = 0;i< 4;i++)
        {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if(nx < 0 || ny < 0 || nx >= row|| ny >= col)
                continue;

            if(grid[nx][ny] == '0')
                continue;

            dfs(grid, nx, ny, row, col);
        }
    }
}