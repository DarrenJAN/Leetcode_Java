package com.company;

public class Sort_Colors {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int i = 0;
        while(i < len-1)
        {
            if(nums[i] > nums[i+1])
            {
                int tmp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = tmp;
                i = 0;
            }
            else
            {
                i++;
            }
        }
    }

    public void sortColors_2(int[] nums) {
        int pos_0 = 0;
        int pos_2 = nums.length-1;
        int cur =0;
        while(cur <=  pos_2)
        {
            if(nums[cur]  == 2)
            {
                nums[cur] = nums[pos_2];
                nums[pos_2] = 2;
                pos_2--;
            } else if(nums[cur] == 0)
            {
                nums[cur] = nums[pos_0];
                nums[pos_0] = 0;
                pos_0++;
                cur++;
            }else
            {
                cur++;
            }
        }
    }
}
