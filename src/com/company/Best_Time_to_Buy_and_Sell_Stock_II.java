package com.company;

public class Best_Time_to_Buy_and_Sell_Stock_II {
    public int maxProfit(int[] prices) {
        int max = 0;
        for(int i = 1;i<prices.length;i++)
        {
            if(prices[i] > prices[i-1])
                max+= (prices[i] - prices[i-1]);
        }
        return max;

    }

    public int maxProfit_dp(int[] prices) {
        int length = prices.length;
        int[][] dp = new int[length][2];
        dp[0][0] = 0 - prices[0]; // dp[i][0] state: hold a stock
        dp[0][1] = 0;             // dp[i][1] state: does not hold a stock
        for(int i = 1 ; i < length; i++)
        {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
        }

        return Math.max(dp[length-1][0], dp[length-1][1]);

    }
}
