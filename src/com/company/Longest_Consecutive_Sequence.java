package com.company;

import java.util.HashSet;

public class Longest_Consecutive_Sequence {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;

        HashSet<Integer> hashSet = new HashSet<>();
        for(Integer integer: nums)
        {
            hashSet.add(integer);
        }

        int max_streak = 1;
        for(int i = 0; i<nums.length;i++)
        {
            int cur_num = nums[i];
            if(!hashSet.contains(cur_num-1))
            {
                int cur_streak = 1;

                while(hashSet.contains(cur_num+1))
                {
                    cur_streak++;
                    max_streak = Math.max(max_streak, cur_streak);

                    cur_num = cur_num+1;
                }
            }
        }
        return max_streak;
    }
}
