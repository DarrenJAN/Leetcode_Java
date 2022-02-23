package com.company;

public class Best_Time_to_Buy_and_Sell_Stock_III {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[] left = new int[n];
        int[] right = new int[n+1];

        int left_min_prince = 0;
        int right_max_prince = 0;
        for(int i = 0;i<n;i++)
        {
            int j = n - i-1;
            if(i == 0 )
            {
                left[0] = 0;
                right[j] = 0;
                left_min_prince = prices[i];
                right_max_prince = prices[j];

            }
            else
            {
                left[i] = Math.max(left[i-1], prices[i] - left_min_prince);
                left_min_prince = Math.min(left_min_prince, prices[i]);

                right[j] = Math.max(right[j+1], right_max_prince - prices[j] );
                right_max_prince = Math.max(right_max_prince, prices[j]);
            }

        }

        int max_pro = 0;
        for(int i = 0;i< n;i++)
        {
            max_pro = Math.max(max_pro, left[i] + right[i+1]);
        }
        return max_pro;
    }
}
