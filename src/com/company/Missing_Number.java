package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Missing_Number {
    public int missingNumber(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();

        for(int i : nums)
            hashSet.add(i);

        for(int i = 0;i<nums.length;i++)
        {
            if( !hashSet.contains(i))
                return i;
        }
        return nums.length;

    }


    //no extra space
    public int missingNumber_2(int[] nums) {
        int length = nums.length;

        int sum = length * (length +1)/2;
        int nums_sum = 0;
        for(int i = 0;i< nums.length;i++)
        {
            nums_sum += nums[i];
        }
        return sum - nums_sum;
    }
}
