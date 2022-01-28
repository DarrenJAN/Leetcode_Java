package com.company;

public class Find_First_and_Last_Position_of_ElementinSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if( nums.length == 0)
            return result;

        int a = find_left(nums, target);
        int b = find_right(nums, target);

        result[0] = a;
        result[1] = b;
        return  result;

    }

    public int find_left(int[] nums, int target)
    {
        int left = 0;
        int right = nums.length-1;

        while( left < right)
        {
            int mid = (right - left) / 2 + left;
            if( nums[mid] == target)
            {
                left = mid -1;
                right = mid;

            } else if (nums[mid] > target)
            {
                right = mid -1 ;
            } else
            {
                left  = mid +1;
            }
        }

        return left;
    }

    public int find_right(int[] nums, int target)
    {
        int left = 0;
        int right = nums.length-1;

        while( left < right)
        {
            int mid = (right - left) / 2 + left;
            if( nums[mid] == target)
            {
                left = mid;
                right = mid+1;

            } else if (nums[mid] > target)
            {
                right = mid -1 ;
            } else
            {
                left  = mid +1;
            }
        }

        return right;
    }
}
