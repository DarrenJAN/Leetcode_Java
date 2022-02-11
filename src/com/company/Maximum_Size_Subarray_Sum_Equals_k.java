package com.company;

import java.util.HashMap;
import java.util.HashSet;

public class Maximum_Size_Subarray_Sum_Equals_k {
    //暴力解法
    public int maxSubArrayLen(int[] nums, int k) {
        int result = 0;
        int len = nums.length;

        for(int i= 0;i<len;i++)
        {
            int sum = nums[i];
            if (sum == k)
                result = Math.max(result, 1);
            for(int j = i+1;j<len;j++)
            {
                sum += nums[j];
                if(sum == k)
                {
                    result = Math.max(result, j-i +1);
                }
            }
        }

        return result;
    }

    //prefix
    public int maxSubArrayLen_2(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int presum = 0;
        int result = 0;

        for(int i =0;i<nums.length;i++)
        {
            presum += nums[i];

            if(presum == k)
                result = i+1;

            if(!hashMap.containsKey(presum))
                hashMap.put(presum, i);

            if( hashMap.containsKey(presum - k ))
            {
                result = Math.max(result, i - hashMap.get(presum -k) +1);
            }
        }
        return result;
    }
}
