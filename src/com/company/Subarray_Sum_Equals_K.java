package com.company;

import java.util.HashMap;

public class Subarray_Sum_Equals_K {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int cur_sum = 0;
        for(int num : nums)
        {
            cur_sum += num;

            //situation 1
            if(cur_sum == k)
                count ++;

            //situtaion 2
            count += hashMap.getOrDefault(cur_sum - k, 0);


            //add cur_sum
            hashMap.put(cur_sum, hashMap.getOrDefault(cur_sum, 0) +1);
        }
        return count;
    }
}
