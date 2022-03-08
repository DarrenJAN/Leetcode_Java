package com.company;

public class Last_Stone_Weight_II {
    public int lastStoneWeightII(int[] stones) {
        int totalsum = 0;
        for(int i : stones)
            totalsum+= i;

        int half = totalsum/2;
        int[] dp = new int[half+1];

        for(int i = 0;i<stones.length;i++)
        {
            for(int j = half;j>= stones[i];j--)
            {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }

        return totalsum - 2 * dp[half];
    }
}
