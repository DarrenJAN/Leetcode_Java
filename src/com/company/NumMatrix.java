package com.company;

class NumMatrix {
    int[][] dp;
    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        dp = new int [row+1][col+1];

        for(int i = 1; i< row+1;i++)
        {
            for(int j = 1 ; j< col+1;j++)
            {
                dp[i][j] = matrix[i-1][j-1] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
            }
        }


    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int a = dp[row1][col1];
        int b = dp[row2+1][col1];
        int c = dp[row1][col2+1];

        return dp[row2+1][col2+1] - b - c + a ;
    }
}

