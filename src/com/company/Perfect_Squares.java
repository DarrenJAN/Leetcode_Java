package com.company;

public class Perfect_Squares {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        int sq = (int)Math.sqrt(n);
        if (sq * sq == n )
            return 1;
        int[] sqrs = new int[sq+1];

        for(int i = 0;i<sqrs.length;i++)
        {
            sqrs[i] = i*i;
        }
        for(int i = 2;i<= n;i++)
        {
            dp[i] = Integer.MAX_VALUE;
            for(int j = 1;j<= (int)Math.sqrt(i);j++)
            {
                int sqrts = sqrs[j];
                dp[i] = Math.min(dp[i], dp[i-sqrts] +1);
            }
            //System.out.println(dp[i]+ " ");
        }
        return dp[n];

    }
}
