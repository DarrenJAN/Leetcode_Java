package com.company;

import java.util.Arrays;

public class ThreeSum_Closest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        int min_diff = Integer.MAX_VALUE;

        for(int i = 0; i< nums.length-2;i++)
        {
            int j = i+1;
            int k = nums.length-1;

            while(j < k)
            {
                int a = nums[i];
                int b = nums[j];
                int c = nums[k];
                int sum = a+ b + c;
                if(sum == target)
                    return target;
                else
                {
                    if(min_diff > Math.abs(sum - target))
                    {
                        result = sum;
                        min_diff = Math.abs(sum - target);
                    }


                    if(sum < target)
                    {
                        j++;
                    }else
                    {
                        k--;
                    }
                }
            }
        }

        return result;
    }
}
