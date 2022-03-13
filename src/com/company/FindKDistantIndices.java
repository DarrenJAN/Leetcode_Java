package com.company;

import java.util.*;

public class FindKDistantIndices {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> result = new ArrayList<>();
        HashSet<Integer> hashSet = new HashSet<>();

        for(int i = 0;i<nums.length;i++)
        {
            if(nums[i] == key)
            {
                for(int j = i -k; j<= i+k;j++)
                {
                    if(j >= 0 && j< nums.length)
                        hashSet.add(j);
                }
            }
        }
        for(Integer i : hashSet)
            result.add(i);

        Collections.sort(result);
        return result;
    }
}
