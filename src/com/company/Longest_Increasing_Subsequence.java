package com.company;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Longest_Increasing_Subsequence {
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        int result = 0;

        for(int i = 0;i<nums.length;i++)
        {
            for(int j = 0;j< i;j++)
            {
                if( nums[i] > nums[j])
                {
                    dp[i] = Math.max(dp[i], dp[j] + 1 );
                    result = Math.max(result, dp[i]);
                }

            }
        }
        return result+1;
    }

    public int lengthOfLIS_2(int[] nums) {
        int length = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        if(nums.length == 0)
            return 0;

        list.add(nums[0]);

        for(int i = 1;i< length;i++)
        {
            if(nums[i] > list.get(list.size()-1))
                list.add(nums[i]);
            else
            {
                int index = getindex(list, nums[i]);
                list.set(index, nums[i]);
            }
        }
        return list.size();
    }

    int getindex(ArrayList<Integer> list, int target )
    {
        int l = 0;
        int r= list.size()-1;

        while(l <= r)
        {
            int mid = (r - l)/2 + l;
            if(list.get(mid) < target)
                l = mid+1;
            else
                r = mid -1;
        }
        return l;
    }
}
