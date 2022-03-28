package com.company;

public class Wiggle_Subsequence {
    public int wiggleMaxLength(int[] nums) {
        int length = nums.length;
        if(length == 1 || length == 0)
            return length;



        int[][] dp = new int[length][2];
        dp[0][0] = 1;
        dp[0][1] = 1;

        for(int i = 1; i < nums.length;i++)
        {
            if(nums[i] > nums[i-1])
            {
                dp[i][0] = dp[i-1][1]+1;
                dp[i][1] = dp[i-1][1];
            }else if(nums[i] < nums[i-1])
            {
                dp[i][1] = dp[i-1][0]+1;
                dp[i][0] = dp[i-1][0];
            }else
            {
                dp[i][1] = dp[i-1][1];
                dp[i][0] = dp[i-1][0];
            }

        }

        return Math.max(dp[length-1][0], dp[length-1][1]);
    }


    public int wiggleMaxLength_greedy(int[] nums) {
        int length =nums.length;
        if(length <=  1)
            return length;

        int cur_different =0;
        int pre_different = nums[1] - nums[0];
        int count = pre_different != 0 ? 2 : 1;
        for(int i = 2; i < length; i++)
        {
            cur_different = nums[i] - nums[i-1];
            if((pre_different <= 0 && cur_different > 0 ) || (pre_different >= 0 && cur_different < 0))
            {
                count++;
                pre_different = cur_different;
            }
        }
        return count;
    }
}
