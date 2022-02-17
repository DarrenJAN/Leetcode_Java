package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arithmetic_Subarrays {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n = nums.length;
        int m = l.length;

        List<Boolean> result = new ArrayList<>();

        for(int i = 0 ;i< m;i++)
        {
            Boolean cur = check_helper(nums, l[i], r[i]);
            result.add(cur);
        }

        return result;
    }

    public boolean check_helper(int[] nums, int l, int r)
    {
        int[] nu = nums.clone();
        Arrays.sort(nu, l, r+1);

        for(int i =l+2;i<= r ;i++)
        {
            if(nu[i] - nu[i-1] != nu[i-1] - nu[i-2] )
                return false;
        }
        return true;
    }
}
