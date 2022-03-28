package com.company;

public class Best_Time_to_Buy_and_Sell_Stock_TransactionFee {
    public int maxProfit(int[] prices, int fee) {
        int length = prices.length;
        int[][] dp = new int[length][2];

        //dp[i][0]: currently hold a stock
        //dp[i][1]: currently doesn't hold a stock
        dp[0][0] = 0 - prices[0];
        dp[0][1] = 0;

        for(int i = 1; i < length; i++)
        {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i] - fee);
        }

        return Math.max(dp[length-1][0], dp[length-1][1]);
    }
}
