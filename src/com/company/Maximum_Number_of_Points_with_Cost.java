package com.company;

public class Maximum_Number_of_Points_with_Cost {
    public long maxPoints(int[][] points) {
        int row = points.length;
        int col = points[0].length;
        long result = 0;
        long[] dp = new long[col];
        for(int i = 0 ; i< row;i++)
        {
            dp[0] += points[i][0];

            for(int j = 1;j<col;j++)
            {
                dp[j] = Math.max(dp[j-1]-1, dp[j]+points[i][j]);
            }
            for(int j = col-2;j>=0 ;j--)
            {
                dp[j] = Math.max(dp[j], dp[j+1]-1);
            }

        }

        for(int j = 0;j<col ;j++)
        {
            result = Math.max(dp[j], result);
        }
        return result;
    }
}
