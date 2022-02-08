package com.company;

public class Maximum_Product_Subarray {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if(len ==1)
            return nums[0];

        int[] dp_max = new int[len];
        int[] dp_min = new int[len];
        dp_max[0] = nums[0];
        dp_min[0] = nums[0];

        int result = nums[0];

        for(int i = 1;i<len;i++)
        {
            if(nums[i] == 0)
            {
                dp_max[i] = 0;
                dp_min[i] = 0;
            }else
            {
                dp_max[i] = Math.max(dp_max[i-1] * nums[i], dp_min[i-1] * nums[i]);
                dp_max[i] = Math.max(dp_max[i], nums[i]);

                dp_min[i] = Math.min(dp_max[i-1] * nums[i], dp_min[i-1] * nums[i]);
                dp_min[i] = Math.min(dp_min[i], nums[i]);
            }
            result = Math.max(dp_max[i], result);
        }
        return result;
    }
}
