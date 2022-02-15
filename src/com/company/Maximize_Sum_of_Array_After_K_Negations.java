package com.company;

import java.util.Arrays;

public class Maximize_Sum_of_Array_After_K_Negations {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int result = 0;
        Arrays.sort(nums);

        for(int i = 0;i< nums.length;i++)
        {
            result += nums[i];
        }

        if(k % 2 == 0 && nums[0] >= 0)
            return result;
        else if(k % 2 != 0 && nums[0] >= 0)
        {
            result -= 2 * nums[0];
            return result;
        }

        for(int i = 0;i< nums.length;i++)
        {
            if( k > 0  && nums[i] < 0)
            {
                result =  result - 2 * nums[i];
                k--;
                if(i == nums.length-1 && k > 0 && k % 2 != 0)
                {
                    result += 2*nums[i];
                    break;
                }
            }else if(nums[i] == 0)
                break;
            else if (k>  0 && k % 2 != 0)
            {
                result -= 2 * Math.min(Math.abs(nums[i-1]), nums[i]);
                break;

            }
            else
                break;
        }
        return result;
    }
}
