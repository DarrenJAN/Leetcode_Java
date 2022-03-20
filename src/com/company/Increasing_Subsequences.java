package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Increasing_Subsequences {
    List<List<Integer>> result = new ArrayList<>();
    HashSet<List<Integer>> hashset =new HashSet<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backtrack(new ArrayList<>(), nums, 0);

        return result;
    }

    public void backtrack(List<Integer> path, int[] nums, int start)
    {
        if(path.size() >= 2)
        {
            if(!hashset.contains(path))
            {
                List<Integer> cur = new ArrayList<>(path);
                result.add(cur);
                hashset.add(cur);
            }
        }

        for(int i = start; i< nums.length;i++)
        {
            if(path.size() != 0 && nums[i] < path.get(path.size()-1))
            {
                continue;
            }
            if(i > start && nums[i] == nums[i-1])
                continue;
            path.add(nums[i]);
            backtrack(path, nums, i+1);
            path.remove(path.size()-1);
        }
    }
}
