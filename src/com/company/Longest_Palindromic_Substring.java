package com.company;

public class Longest_Palindromic_Substring {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int start = 0;
        int end =0;

        for(int i = 0; i< n;i++)
        {
            start = i;
            end = i;
            dp[i][i] = true;
        }

        for(int i = 0; i< n-1;i++)
        {
            if( s.charAt(i) == s.charAt(i +1))
            {
                start = i;
                end = i +1;
                dp[i][i+1] = true;
            }
        }

        for(int len = 2; len < n;len++)
        {
            for(int i = 0; i + len < n; i++)
            {
                int j = i +len;
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1])
                {
                    start = i;
                    end = j;
                    dp[i][j] = true;
                }
            }
        }

        return s.substring(start, end +1);
    }

}
