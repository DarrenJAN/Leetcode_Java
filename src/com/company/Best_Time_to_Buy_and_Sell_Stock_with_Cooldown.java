package com.company;

public class Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[][] dp = new int[length][3];
        //dp[i][0]: current state hold a stock
        //dp[i][1]: current state does not hold a stock
        //dp[i][2]: current state is in cooldown

        dp[0][0] = 0 - prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;

        for(int i = 1; i < length; i++)
        {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2] - prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1]);
        }

        return Math.max(dp[length-1][0],  Math.max(dp[length-1][1], dp[length-1][2]));
    }
}
