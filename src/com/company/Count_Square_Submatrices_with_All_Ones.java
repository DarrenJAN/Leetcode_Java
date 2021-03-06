package com.company;

public class Count_Square_Submatrices_with_All_Ones {
    public int countSquares(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] dp = new int[row+1][col+1];

        int count = 0;
        for(int i = 1;i<=row ;i++)
        {
            for(int j = 1;j<= col;j++)
            {
                if(matrix[i-1][j-1] == 0)
                {
                    dp[i][j]= 0;
                }else
                {
                    int tmp = Math.min(dp[i-1][j] , dp[i][j-1]);
                    dp[i][j] = Math.min(tmp, dp[i-1][j-1])+1;
                }

                count+= dp[i][j];
            }
        }
        return count;
    }
}
