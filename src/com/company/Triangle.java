package com.company;

import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int length =triangle.size();
        int[][] dp = new int[length][length];

        dp[0][0]= triangle.get(0).get(0);

        for(int i = 1;i<length;i++)
        {
            for(int j = 0;j<= i;j++)
            {
                if(j == 0 )
                {
                    dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
                }else if(j == i)
                {
                    dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
                }
                else
                {
                    dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + triangle.get(i).get(j);
                }
                //System.out.print(dp[i][j] + " ");
            }
            // System.out.println();
        }

        int result = Integer.MAX_VALUE;
        for(int i = 0;i<length;i++)
        {
            result = Math.min(result,dp[length-1][i]);
        }
        return result;
    }
}
