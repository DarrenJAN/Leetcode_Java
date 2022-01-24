package com.company;

import java.util.Arrays;

public class Contains_Duplicate {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int n =nums.length;
        for(int i =0; i<n-1;i++)
        {
            if(nums[i] == nums[i+1])
                return true;
        }
        return false;
    }
}
