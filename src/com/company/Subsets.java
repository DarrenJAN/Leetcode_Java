package com.company;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer>  path = new ArrayList<>();
        backtrack(nums, path, 0);
        return result;
    }

    public void backtrack(int[] nums, List<Integer> path, int start)
    {
        result.add(new ArrayList<>(path));

        for(int i = start; i< nums.length;i++)
        {
            path.add(nums[i]);
            backtrack(nums, path, i+1);
            path.remove(path.size()-1);
        }
    }
}
