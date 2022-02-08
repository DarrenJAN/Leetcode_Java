package com.company;

import java.util.Collections;

public class House_Robber_II {
    public int rob(int[] nums) {
        int dp1 = dp_helper(nums);


        for(int i = 0;i < nums.length/2;i++)
        {
            int tmp = nums[i] ;
            nums[i] = nums[nums.length -i -1];
            nums[nums.length -i -1] = tmp;
        }
        int dp2 = dp_helper(nums);

        return Math.max(dp1, dp2);
     }

    public int dp_helper(int[] nums)
    {
        int len = nums.length;
        if(len == 1)
            return nums[0];
        if(len == 2)
        {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2;i<len-1;i++)
        {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
            dp[i] = Math.max(dp[i-2], dp[i]);
        }

        return dp[len-1];
    }
}
