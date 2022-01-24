package com.company;

import java.util.Arrays;
import java.util.Collection;

public class Next_Permutation {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int first_index = -1;
        int second_index = len-1;
        for(int i = len-1; i>0; i--)
        {
            if(nums[i-1] < nums[i])
            {
                first_index = i -1;
                break;
            }

        }

        if(first_index == -1)
        {
            Reverse(nums, 0, len-1);
            return;
        }

        for(int i =first_index+1; i< len; i++)
        {
            if(nums[first_index] >= nums[i])
            {
                second_index = i-1;
                break;
            }

        }

        int tmp = nums[first_index];
        nums[first_index] = nums[second_index];
        nums[second_index] = tmp;

        Reverse(nums, first_index+1, len-1);
    }

    public void Reverse(int[] nums, int l, int r )
    {
        while(l< r)
        {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }
}
