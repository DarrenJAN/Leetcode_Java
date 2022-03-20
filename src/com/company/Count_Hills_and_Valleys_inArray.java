package com.company;

public class Count_Hills_and_Valleys_inArray {

    public int countHillValley(int[] nums) {
        int count = 0;
        boolean up = false;
        boolean down = false;

        for(int i = 1 ; i< nums.length;i++)
        {
            int cur = 0;
            if(nums[i] >  nums[i-1]) {
                up = true;
                if(down == true)
                {
                    count++;
                    down = false;
                }
            }else if( nums[i-1] > nums[i])
            {
                down = true;
                if(up == true)
                {
                    count++;
                    up = false;
                }
            }
        }
        return count;
    }

}
