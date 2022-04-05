package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Wiggle_Sort {
    // O(nlogn)
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for(int i =2;i<nums.length;i+=2)
        {
            int tmp = nums[i-1];
            nums[i-1] =nums[i];
            nums[i] = tmp;
        }
    }

    //O(n)
    public void wiggleSort_2(int[] nums) {
        int flag =1 ;
        for(int i =0 ;i< nums.length-1;i++)
        {
            if(flag == 1)
            {
                if(nums[i] > nums[i+1])
                {
                    swap(nums, i, i+1);
                }
            }else
            {
                if(nums[i] < nums[i+1])
                {
                    swap(nums, i, i+1);
                }
            }
            flag =-flag;
        }
    }

    void swap(int[] nums, int i, int j)
    {
        int tmp = nums[i];
        nums[i]=nums[j];
        nums[j]= tmp;
    }
}
