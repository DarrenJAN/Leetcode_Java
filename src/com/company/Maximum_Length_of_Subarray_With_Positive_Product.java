package com.company;

public class Maximum_Length_of_Subarray_With_Positive_Product {
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        int[] long_post = new int[n+1];
        int[] long_nege = new int[n+1];
        int result = 0;

        for(int i = 0;i<n;i++)
        {
            if( nums[i]  == 0)
            {
                long_post[i+1] = 0;
                long_nege[i+1] = 0;
            }else if(nums[i] > 0)
            {
                long_post[i+1] = long_post[i]+1;
                long_nege[i+1] = long_nege[i] == 0? 0:long_nege[i]+1;
            }else
            {
                long_post[i+1] = long_nege[i] == 0 ? 0:long_nege[i] +1;
                long_nege[i+1] = long_post[i] + 1;
            }

            result = Math.max(result, long_post[i+1]);
        }
        return result;
    }
}
