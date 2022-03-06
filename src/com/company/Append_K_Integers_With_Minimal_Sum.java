package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Append_K_Integers_With_Minimal_Sum {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        long result = 0;
        long K = (long) k;
        result = K *(K+1) /2;


        for(int i= 0;i< nums.length;i++)
        {
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            if(nums[i]<=k)
            {
                k++;
                result = result - nums[i] + k;
            }
            //System.out.println(result);
        }
        return result;
    }

    //1983286874545

    //


}
