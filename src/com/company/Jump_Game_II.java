package com.company;

public class Jump_Game_II {
    public int jump(int[] nums) {
        int n = nums.length;
        int steps = 0;
        int cur_pos = 0;
        int cur_end = 0;

        for(int i = cur_pos;i< nums.length-1;i++)
        {
            cur_pos = Math.max(cur_pos, i + nums[i]);

            if(i == cur_end)
            {
                steps ++;
                cur_end=cur_pos;
            }
        }

        return steps;
    }

}
