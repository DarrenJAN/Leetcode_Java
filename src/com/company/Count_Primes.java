package com.company;

public class Count_Primes {
    public int countPrimes(int n) {
        if(n <= 2)
            return 0;
        boolean[] dp = new boolean[n+1];

        int count =  0;
        for(int i = 2;i< n;i++)
        {
            if(dp[i] == false)
                count++;
            for(int j = 2; j*i <= n;j=j*i)
            {
                dp[j] = true;
            }
        }
        return count;
    }


}
