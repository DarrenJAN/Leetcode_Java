package com.company;

public class Minimum_Path_Sum {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        if(row == 0)
            return 0;
        int col = grid[0].length;

        int[][] dp = new int[row+1][col+1];

        for(int i = 1 ;i<= row;i++) {
            for (int j = 1; j <= col; j++)
            {
                if( i == 1 )
                    dp[i][j] =  dp[i][j-1] + grid[i-1][j-1];
                else if( j == 1)
                    dp[i][j] = dp[i-1][j] + grid[i-1][j-1];
                else
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i-1][j-1];
            }
        }
        return dp[row][col];

    }
}
