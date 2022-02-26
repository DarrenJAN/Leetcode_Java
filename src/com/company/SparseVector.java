package com.company;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

class SparseVector {
    int[] nums;
    HashSet<Integer> index ;
    SparseVector(int[] nums) {
        this.nums = nums;
        index = new HashSet<>();

        for(int i = 0;i< nums.length;i++)
        {
            if(nums[i] != 0)
                index.add(i);
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int result = 0;

        for( Integer inx : index )
        {
            if(vec.index.contains(inx))
                result += (nums[inx] * vec.nums[inx]);
        }
        return result;
    }
}
