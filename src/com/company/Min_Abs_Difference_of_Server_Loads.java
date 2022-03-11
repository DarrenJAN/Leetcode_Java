package com.company;

public class Min_Abs_Difference_of_Server_Loads {
    public int Min_Abs(int[] nums) {
        int total = 0;
        for(int i :nums)
            total+= i;

        int half = total /2;
        int[] dp = new int[half+1];
        for(int i =0;i<nums.length;i++)
        {
            for(int j= half;j>= nums[i];j--)
            {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }

        return total - 2 * dp[half];
    }
}
