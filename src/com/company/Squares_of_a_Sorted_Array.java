package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Squares_of_a_Sorted_Array {
    public int[] sortedSquares(int[] nums) {
        for(int i = 0; i<nums.length;i++)
            nums[i] = nums[i]^2;
        Arrays.sort(nums);
        return nums;
    }

    public int[] sortedSquares_2(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int[] result = new int[nums.length];
        for(int i = nums.length-1;i>=0;i--)
        {
            int tmp_left = nums[left] * nums[left];
            int tmp_right = nums[right] * nums[right];
            if(tmp_left > tmp_right)
            {
                result[i] = tmp_left;
                left++;
            }else
            {
                result[i] = tmp_right;
                right--;
            }
        }
        return result;
    }
}
