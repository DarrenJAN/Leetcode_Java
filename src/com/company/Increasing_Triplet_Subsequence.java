package com.company;

public class Increasing_Triplet_Subsequence {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for(Integer num: nums)
        {
            if(num < first)
                first = num;
            else if (num < second && num > first)
                second = num;
            else if(num > first && num > second)
                return true;
        }
        return false;
    }
}
