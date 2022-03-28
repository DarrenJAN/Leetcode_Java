package com.company;

public class Find_Pivot_Index {
    public int pivotIndex(int[] nums) {
        int total_sum = 0;
        for(int i = 0;i< nums.length;i++)
        {
            total_sum += nums[i];

        }
        if(total_sum == 0)
            return 0;

        int left = 0;
        int right = total_sum;
        for(int i =1;i<nums.length;i++)
        {
            left   += nums[i-1];
            right = total_sum - left - nums[i];
            if(left == right)
                return i;
        }
        return -1;
    }

}
