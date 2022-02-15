package com.company;

public class Jump_Game {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int cur_max = 0;

        for(int i = 0;i <= cur_max;i++)
        {
            cur_max = Math.max(cur_max, i + nums[i]);
            if( cur_max >= n-1)
                return true;
        }
        return false;
    }

    public boolean canJump_2(int[] nums) {
        return backtrack(0, nums);
    }

    public boolean backtrack(int pos, int[] nums)
    {
        if(pos >= nums.length-1)
        {
            return true;
        }

        int furestJump = pos + nums[pos];
        for(int i = pos + 1; i< furestJump;i++ )
        {
            if(backtrack(i, nums))
                return true;
        }

        return false;
    }
}
