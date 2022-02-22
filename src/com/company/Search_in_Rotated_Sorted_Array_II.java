package com.company;

public class Search_in_Rotated_Sorted_Array_II {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while(left <= right)
        {
            while(left < right && nums[left] == nums[left+1]) {
                left++;
            }
            while(left < right && nums[right] == nums[right-1])
                right --;

            int mid = (right - left)/2 + left;

            if(nums[mid] == target)
            {
                return true;
            }else if(nums[mid] >= nums[left])
            {
                if(target < nums[mid] && target>= nums[left])
                    right = mid -1;
                else
                    left = mid +1;
            }else
            {
                if(target > nums[mid] && target <= nums[right])
                    left = mid +1;
                else
                    right = mid-1;
            }
        }
        return false;
    }
}
