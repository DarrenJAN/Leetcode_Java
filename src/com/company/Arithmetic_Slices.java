package com.company;

public class Arithmetic_Slices {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int result = 0;
        int[] dp = new int[n];

        for(int i = 2;i< n;i++)
        {
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2] )
            {
                dp[i] = dp[i-1] + 1;
                result+= dp[i];
            }
        }
        return result;
    }
}
