package com.company;

import java.util.HashMap;

public class Contiguous_Array {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int nums_zeros = 0;
        int result = 0;
        for(int i = 0; i< nums.length;i++)
        {
            if(nums[i] == 0)
                nums_zeros ++;
            else
                nums_zeros --;

            if(nums_zeros == 0)
            {
                result = i+1;
            }

            if(!hashMap.containsKey(nums_zeros))
                hashMap.put(nums_zeros, i);
            else
                result = Math.max(result, i - hashMap.get(nums_zeros));

        }
        return result;
    }

    //            if(nums[i] == 0)
//            {
//                if( hashMap.containsKey(nums_zeros + 1))
//                {
//                    result = Math.max(result, i - hashMap.get(nums_zeros+));
//                }
//            }else
//            {
//                if( hashMap.containsKey(nums_zeros-1))
//                {
//                    result = Math.max(result, i - hashMap.get(nums_zeros+));
//                }
//            }
}
