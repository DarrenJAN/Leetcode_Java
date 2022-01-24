package com.company;

import java.util.LinkedList;
import java.util.List;

public class Permutations {
    List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        backtrack(0,new LinkedList<>(), n, nums);
        return result;

    }

    public void backtrack(int pos, List<Integer> path, int len, int[] nums)
    {
        if(path.size() == len)
        {
            result.add(new LinkedList<>(path));
            return;
        }

        for(int i = 0 ; i< len;i++)
        {
            if( ! path.contains(nums[i]))
            {
                path.add(nums[i]);
                backtrack(pos+1, path, len, nums);
                path.remove(path.size()-1);
            }
        }
    }

}
