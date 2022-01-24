package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class Two_Sum_III {
    List<Integer> nums;
    boolean is_sorted = false;

    public Two_Sum_III() {
        nums =  new ArrayList<>();
    }

    public void add(int number) {
        nums.add(number);
        is_sorted = false;
    }

    public boolean find(int value) {
        if(!is_sorted)
        {
            Collections.sort(nums);
            is_sorted = true;
        }

        int l = 0;
        int r = nums.size()-1;
        while(l < r)
        {
            int sum = nums.get(l) + nums.get(r);
            if(sum == value)
            {
                return true;
            }else if(sum < value)
                l++;
            else
                r--;
        }

        return  false;
    }
}
