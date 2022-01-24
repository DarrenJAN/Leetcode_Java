package com.company;

public class Remove_Duplicates_from_Sorted_Array {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n == 0)
            return 0;

        int j = 1;
        for(int i =1; i< n;i++)
        {
            if(nums[i] != nums[i-1])
            {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

}
