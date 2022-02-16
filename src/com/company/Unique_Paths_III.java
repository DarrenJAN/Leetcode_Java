package com.company;

public class Unique_Paths_III {
    int[][] dir = new int[][]{{0,1}, {0,-1}, {1,0}, {-1, 0}};
    int result = 0;
    public int uniquePathsIII(int[][] grid) {
        int row=grid.length;
        int col = grid[0].length;
        int startx = 0;
        int starty = 0;
        int num_walks = 0;
        for(int i = 0;i<row;i++)
        {
            for(int j= 0;j< col;j++)
            {
                if(grid[i][j] == 1)
                {
                    startx = i;
                    starty = j;
                }

                if(grid[i][j] == 0)
                    num_walks++;
            }
        }

        //System.out.println(num_walks+1);
        backtrack(grid, startx, starty, num_walks+1);
        return result;
    }

    public void backtrack(int[][] grid, int row, int col, int num_walks)
    {
        if(row< 0 || col < 0 || row >= grid.length || col>= grid[0].length)
            return;

        if(grid[row][col] == 4 || grid[row][col] == -1)
            return;

        if(grid[row][col] == 2 )
        {
            if(num_walks == 0)
            {
                result ++;
            }
            return;
        }

        int tmp = grid[row][col];
        grid[row][col] = 4;
        num_walks -= 1;
        for(int i = 0;i< 4;i++)
        {
            int x = row + dir[i][0];
            int y = col + dir[i][1];

            backtrack(grid, x, y, num_walks);
        }

        grid[row][col] = tmp;
    }
}
