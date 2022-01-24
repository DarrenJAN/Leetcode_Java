package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Single_Number {
    public int singleNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for(int i =0;i<nums.length;i++)
        {
            if(list.contains(nums[i]))
            {
                list.remove(list.indexOf(nums[i]));
            }else
                list.add(nums[i]);
        }

        return list.get(0);
    }
}
