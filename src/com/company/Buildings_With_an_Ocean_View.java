package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Buildings_With_an_Ocean_View {
    public int[] findBuildings(int[] heights) {
        int n = heights.length;
        int[] dp = new int[n+1];
        List<Integer> result = new ArrayList<>();
        for(int i = n-1;i>=0 ;i--)
        {
            if(i == n-1)
            {
                dp[i] = heights[i];
                result.add(i);
                continue;
            }

            dp[i]= Math.max(heights[i+1], dp[i+1]);
            if (dp[i] < heights[i] )
                result.add(i);
        }
        int[] ans = new int[result.size()];
        for(int i = 0;i< result.size();i++)
            ans[i] = result.get(result.size() -i -1);
        return ans;
    }
}
