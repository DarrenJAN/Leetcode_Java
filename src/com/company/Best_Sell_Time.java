package com.company;

public class Best_Sell_Time {
    public int maxProfit(int[] prices) {
        int min_prince = prices[0];
        int max_profit = 0;

        for(int i = 0;i<prices.length;i++)
        {
            if(min_prince > prices[i])
                min_prince = prices[i];

            max_profit = Math.max(max_profit, prices[i] - min_prince);
        }

        return max_profit;
    }
}
