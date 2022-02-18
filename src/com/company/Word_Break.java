package com.company;

import java.util.HashSet;
import java.util.List;

public class Word_Break {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> hashSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];

        dp[0] = true;

        for(int i= 1;i<=s.length();i++)
        {
            for(int j = 0; j < i;j++)
            {
                if(dp[j]  == true && hashSet.contains(s.substring(j,i)))
                {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
