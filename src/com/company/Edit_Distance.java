package com.company;

public class Edit_Distance {
    public int minDistance(String word1, String word2) {
        int w1_len = word1.length();
        int w2_len = word2.length();

        int[][] dp = new int[w1_len+1][w2_len+1];

        for(int i = 0;i<=w1_len;i++)
        {
            for(int j = 0;j<=w2_len;j++)
            {
                if(i == 0 && j ==0)
                    continue;
                if(i == 0 && j> 0)
                {
                    dp[0][j] = dp[0][j-1] +1;
                    continue;
                }

                if(j == 0 && i > 0)
                {
                    dp[i][0] = dp[i-1][0] +1;
                    continue;
                }

                char w1 = word1.charAt(i-1);
                char w2 = word2.charAt(j-1);
                if(w1 == w2)
                {
                    dp[i][j] = dp[i-1][j-1];
                }else
                {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) ;
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]) +1;
                }

            }
        }
        return dp[w1_len][w2_len];
    }
}
