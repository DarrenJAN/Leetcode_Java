package com.company;

public class Subarray_Product_Less_Than_K {
    //这个方法不能handle 最大数最小数
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int result =  0;
        int len = nums.length;
        for(int size = 1 ; size <= len; size++ )
        {
            int sum = 1;
            for(int i = 0 ;i< len;i++)
            {
                sum = sum * nums[i];
                if( i >= size)
                {
                    sum = sum / nums[i - size];
                }

                if(sum  <  k && i>= size-1 )
                    result++;
            }
        }
        return result;
    }

    public int numSubarrayProductLessThanK_2(int[] nums, int k) {
        if(k <= 1)
            return 0;
        int result = 0;
        int sum = 1;
        int j = 0;
        for(int i = 0; i< nums.length;i++)
        {
            sum =  sum * nums[i];

            while(sum >= k)
            {
                sum = sum / nums[j];
                j++;
            }
            result +=  (i - j +1);
        }
        return result;
    }
}
