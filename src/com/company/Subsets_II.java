package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_II {
    List<List<Integer>> result  = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, new ArrayList<>(), 0);
        return result;
    }

    public void backtrack(int[] nums, List<Integer> path, int start)
    {
        result.add(new ArrayList<>(path));

        for(int i= start;i< nums.length;i++)
        {
            if( i > start && nums[i] == nums[i-1])
            {
                continue;
            }
            path.add(nums[i]);
            backtrack(nums, path, i+1);
            path.remove(path.size()-1);


        }
    }
}
