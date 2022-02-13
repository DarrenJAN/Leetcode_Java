package com.company;

public class Make_the_Array_Alternating {
    public int minimumOperations(int[] nums) {
        int n  = nums.length;
        int[] dp = new int[n];
        if(n == 1)
            return 0;
        if(n == 2)
            return nums[0]== nums[1] ? 1:0;

        dp[0] = 0;
        dp[1] = nums[0]== nums[1] ? 1:0;

        for(int i = 2; i< n;i++)
        {
            if(nums[i-2] == nums[i])
            {
                dp[i] = dp[i-2];
            }else if(nums[i-2] == nums[i-1])
            {
                dp[i] = Math.min(dp[i-1], dp[i-2]) +1;
            }else
            {
                dp[i] = Math.min(dp[i-1], dp[i-2]) +1;
            }

        }

        return dp[n-1];
    }
}
