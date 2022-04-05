package com.company;

public class Coin_Change {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        if(amount == 0)
            return 0;
        for(int i = 1;i<= amount;i++)
        {
            dp[i] = amount+1;
            for(int coin: coins)
            {
                if(i >= coin)
                {
                    dp[i] = Math.min(dp[i], dp[i- coin]  +1);
                }
            }
        }
        if(dp[amount] > amount)
            return -1;
        else
            return dp[amount];
    }
}
