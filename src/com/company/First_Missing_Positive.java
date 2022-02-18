package com.company;

import java.util.Arrays;

public class First_Missing_Positive {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int count =0;

        for(int i = 0;i<nums.length;i++)
        {
            if(nums[i] <= 0)
                continue;
            else
            {
                if(i!= 0 && nums[i] == nums[i-1])
                    continue;
                count++;
                if(nums[i] != count)
                    return count;
            }
        }
        return count+1;
    }

    public int firstMissingPositive_2(int[] nums) {
        int n = nums.length;

        for(int i = 0;i<n;i++)
        {
            if(nums[i] <= 0 || nums[i] > n)
                continue;

            int cur_num = nums[i];
            if(nums[cur_num-1] == cur_num )
                continue;
            else
            {
                int tmp = nums[cur_num-1];
                nums[cur_num -1] = cur_num;
                nums[i] = tmp;
                i--;
            }
        }
        for(int i= 0;i<n;i++)
        {
            if(nums[i] != i+1)
                return i+1;
        }
        return n+1;
    }
}
