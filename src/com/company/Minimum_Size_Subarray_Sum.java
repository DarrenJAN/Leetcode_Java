package com.company;

public class Minimum_Size_Subarray_Sum {
    public int minSubArrayLen(int target, int[] nums) {
        int length = 0;
        int sum = 0;
        int j = 0;
        for(int i = 0; i< nums.length;i++) {
            sum = sum + nums[i];

            if (sum >= target) {
                while (sum >= target) {
                    sum = sum - nums[j];
                    j++;
                }
                //Sysmtem.out.prinln("i");
                if (length != 0)
                    length = Math.min(length, i - (j - 1) + 1);
                else
                    length = i - j + 2;
            }

        }
        return length;
    }
}
