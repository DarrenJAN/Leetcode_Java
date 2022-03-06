package com.company;

public class Remove_All_Ones_WithRow_and_Column_Flips {
    private  int row;
    private  int col;
    public boolean removeOnes(int[][] grid) {
        row = grid.length;
        col = grid[0].length;

        for(int i =0;i< row;i++)
        {
            if(grid[i][0] == 1)
                fliprow(grid, i);
        }

        return check_col(grid, 1, col-1);
    }

    public void fliprow(int[][] grid, int cur_row)
    {
        for(int i =0;i<col;i++)
        {
            grid[cur_row][i] = 1- grid[cur_row][i];
        }
    }

    public boolean check_col(int[][] grid, int start_col, int end_col )
    {
        if(start_col > end_col)
        {
            return true;
        }


        for(int i = 0;i< row ;i++)
        {
            int val = grid[i][0];
            for(int j = start_col;j<= end_col;j++)
            {
                if(val != grid[i][j])
                    return false;
            }
        }
        return true;
    }
}
