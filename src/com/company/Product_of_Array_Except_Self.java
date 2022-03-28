package com.company;

public class Product_of_Array_Except_Self {
    public int[] productExceptSelf(int[] nums) {
        int totol_product = 1;
        int count_zero = 0;
        int zero_index = 0;
        for(int i = 0;i< nums.length;i++)
        {
            if(nums[i] == 0){
                count_zero++;
                zero_index = i;
                if(count_zero == 2)
                    break;
                else
                    continue;
            }

            totol_product *= nums[i];

        }

        int[] result = new int[nums.length];
        if(count_zero == 2)
        {
            return result;
        }else if(count_zero == 1)
        {
            result[zero_index] = totol_product;
            return result;
        }

        for(int i = 0;i<nums.length;i++)
        {
            result[i] = totol_product / nums[i];
        }

        return result;


    }

}
