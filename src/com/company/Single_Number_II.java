package com.company;

import java.util.HashMap;
import java.util.HashSet;

public class Single_Number_II {
    public int singleNumber(int[] nums) {
        int sum = 0;
        int totol= 0;
        HashSet<Integer> num = new HashSet<>();

        for(int i = 0; i< nums.length;i++)
        {
            if(!num.contains(nums[i]))
            {
                sum += nums[i];
                num.add(nums[i]);
            }
            totol += nums[i];
        }

        return (3 * sum - totol)/2;
    }



    public int singleNumber_2(int[] nums) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (int num : nums)
            hashmap.put(num, hashmap.getOrDefault(num, 0) + 1);

        for (int k : hashmap.keySet())
            if (hashmap.get(k) == 1) return k;
        return -1;
    }


}
