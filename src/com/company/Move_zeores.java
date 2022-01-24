package com.company;

public class Move_zeores {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int zero_pos = 0;
        boolean zeroflag = false;

        for(int i = 0 ;i < n; i++)
        {
            if(nums[i] == 0)
            {
                if(!zeroflag)
                {
                    zeroflag = true;
                    zero_pos = i;
                } else
                    continue;
            }

            else
            {
                if(zeroflag)
                {
                    nums[zero_pos] = nums[i];
                    nums[i] = 0;
                    zero_pos++;
                } else
                    continue;


            }
        }

    }
}
