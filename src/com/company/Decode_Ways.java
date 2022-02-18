package com.company;

public class Decode_Ways {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1 ;

        for (int i = 0; i < s.length(); i++) {
            char cur_char = s.charAt(i);
            int cur_num = Integer.parseInt(s.substring(i, i + 1));
            if ( cur_num <= 9 && cur_num >= 1)
                dp[i+1] += dp[i ];

            if( i >= 1)
            {
                cur_num = Integer.parseInt(s.substring(i-1, i + 1));
                if( cur_num <= 26 && cur_num >= 10)
                    dp[i + 1] += dp[i - 1];
            }

        }

        return dp[n];
    }


}
