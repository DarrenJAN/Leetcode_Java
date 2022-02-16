package com.company;

public class Unique_Paths_II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        int[][] dp = new int[row+1][col+1];

        for(int i = 1;i <= row;i++)
        {
            for(int j = 1; j<= col;j++)
            {
                if(obstacleGrid[i-1][j-1] == 1)
                    dp[i][j] = 0;
                else if(i== 1 && j == 1)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];

            }
        }

        return dp[row][col];
    }
}
