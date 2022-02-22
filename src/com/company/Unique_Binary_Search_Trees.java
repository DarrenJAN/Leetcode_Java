package com.company;

import java.util.HashMap;

public class Unique_Binary_Search_Trees {
    public int numTrees(int n) {
        int[][] mem = new int[n+1][n+1];
        return helper(1, n, mem);
    }

    public int helper(int start, int end, int[][] mem)
    {
        if(start == end)
            return 1;

        if(start > end)
            return  1;

        if(mem[start][end] != 0)
            return mem[start][end];

        int sum = 0;
        for(int i = start;i <=end;i++)
        {
            int left = helper(start, i-1, mem);
            int right = helper(i+1,end, mem);
            sum+= left*right;
        }

        mem[start][end] = sum;
        return sum;
    }


    public int numTrees_2(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i<= n ;i++)
        {
            for(int j = 1; j<= i;j++)
            {
                dp[i] += ( dp[j-1] * dp[i-j]);
            }
        }
        return dp[n];
    }
}
