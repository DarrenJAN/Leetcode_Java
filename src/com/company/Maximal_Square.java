package com.company;

public class Maximal_Square {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row +1][col +1];
        int result = 0;

        for(int i  = 1 ;i<= row;i++)
        {
            for(int j = 1; j<= col;j++)
            {
                char cur_maxtrix = matrix[i-1][j-1];
                if(cur_maxtrix == '1')
                {
                    dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]);
                    dp[i][j] = Math.min(dp[i][j-1], dp[i][j]);
                    dp[i][j] += 1;

                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result;
    }

}
