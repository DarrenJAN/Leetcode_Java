package com.company;

import java.util.Arrays;

public class Minimum_Difference_in_three_moves {
    public int minDifference(int[] nums) {
        int min = 0;
        Arrays.sort(nums);
        int length = nums.length;
        if(nums.length <=3)
            return 0;

        min = nums[length-1] - nums[0];
        for(int i = 0;i<= 3;i++)
        {
            min = Math.min(min, nums[i+length -3 -1] - nums[i]);
        }
        return min;
    }
}
