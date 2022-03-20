package com.company;

import java.util.HashMap;

public class Make_Sum_Divisible_by_P {
    public int minSubarray(int[] nums, int p) {
        int length = nums.length;
        int sum = 0;
        for(int i : nums)
            sum += i;

        if(sum % p == 0)
            return 0;

        int cur_sum = 0;
        int result = nums.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i =0;i<nums.length;i++)
        {
            cur_sum += nums[i];
            int diff  = cur_sum - nums[i];
            diff = diff % p;

            if(!hashMap.containsKey(diff))
            {
                result = Math.min(result, i - hashMap.get(diff) );
            }
            hashMap.put(diff,i);
        }
        if(result == length)
            return -1;
        else
            return result;
    }
}
