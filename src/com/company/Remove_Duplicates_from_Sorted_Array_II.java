package com.company;

public class Remove_Duplicates_from_Sorted_Array_II {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n < 3)
            return n;

        int count= 1;
        int j = 1;
        for(int i = 1;i<n;i++)
        {
            if(nums[i-1] == nums[i])
            {
                count++;
            }else {
                count = 1;
            }

            if(count <= 2)
            {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
