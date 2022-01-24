package com.company;

public class Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int max = nums[0];
        dp[0] = nums[0];

        for(int i = 1 ;i<n; i++)
        {
            int current_max = Math.max(nums[i], dp[i-1] + nums[i] );
            dp[i] = current_max;
            max = Math.max(max, current_max);
        }

        return dp[n-1];

    }
}
