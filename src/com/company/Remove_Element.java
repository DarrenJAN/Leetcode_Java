package com.company;

public class Remove_Element {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int j = 0;

        for(int i = 0; i< n;i++)
        {
            if(val != nums[i])
            {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

}
