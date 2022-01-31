package com.company;

public class Find_Minimum_in_Rotated_Sorted_Array {
    public int findMin(int[] nums) {
        return divide(nums, 0, nums.length-1);
    }

    public int divide(int[] nums, int l, int r)
    {
        if(l > r)
            return Integer.MAX_VALUE;
        else if(l ==  r )
            return nums[l];

        int mid = (r-l)/2 + l;
        if(nums[l] < nums[r])
        {
            return nums[l];
        }else
        {
            int num_l = divide(nums, l,mid);
            int num_r = divide(nums, mid+1, r);
            return Math.min(num_l, num_r);
        }
    }
}
