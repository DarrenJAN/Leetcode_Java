package com.company;

public class Best_Time_to_Buy_and_Sell_Stock_IV {
    public int maxProfit(int k, int[] prices) {
        int  length = prices.length;

        if(length <= 1)
            return 0;
        int[][] buy = new int[length][k+1];
        int[][] sell = new int[length][k+1];

        //buy[i][j]: currently hold a stock
        //sell[i][j]: currently does not hold a stock

        for(int i =1; i <= k;i++)
        {
            buy[0][i] = 0 - prices[0];
            sell[0][i] = 0;
        }

        for(int i = 1 ; i < length; i++)
        {
            for(int j = 1; j <= k; j++)
            {
                buy[i][j] = Math.max(buy[i-1][j], sell[i-1][j-1] - prices[i]);

                sell[i][j] = Math.max(sell[i-1][j], buy[i-1][j] + prices[i]);
            }
        }

        return Math.max(sell[length-1][k], buy[length-1][k]);
    }
}
