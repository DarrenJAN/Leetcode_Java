package com.company;

import java.util.HashMap;
import java.util.Map;

public class twosum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i<nums.length;i++)
        {
            map.put(nums[i], i);
        }

        for(int i =0 ; i< nums.length;i++)
        {
            int rest = target - nums[i];
            if(map.containsKey(rest) && i != map.get(rest))
            {
                return new int[] {i, map.get(rest)};
            }
        }

        return null;
    }

    public static void main(String[] args) {
        twosum a = new twosum();
        int[] nums = {2,2};

        int[] re = a.twoSum(nums, 4);
        System.out.print(re[0]);
        System.out.print(re[1]);
    }
}
