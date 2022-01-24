package com.company;

public class Search_in_Rotated_Sorted_Array {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        return helper(nums, target, 0, right);
    }

    public int helper(int[]nums, int target, int l, int r)
    {
        if(l > r)
            return -1;

        int mid =  (r - l) / 2 + l;
        if(nums[mid] == target)
            return mid;
        else if(nums[mid] >= nums[l])
        {
            if(nums[mid] > target && target >= nums[l])
                return helper(nums, target, l , mid-1);
            else
                return helper(nums, target, mid+1, r);
        }else
        {
            if(nums[mid] < target && target <= nums[r])
                return helper(nums, target, mid+1,r);
            else
                return helper(nums, target, l, mid-1);
        }
    }
}
