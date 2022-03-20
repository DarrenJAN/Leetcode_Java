package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
    List<List<Integer>> result = new ArrayList<>();
    HashSet <List<Integer>> set = new HashSet<>();
    public List<List<Integer>> permute(int[] nums) {

        boolean[] used = new boolean[nums.length];

        List<Integer> path = new ArrayList<>();
        backtrack(nums, path, 0, used);
        return new ArrayList(set);
    }

    public void backtrack(int[] nums, List<Integer> path, int length, boolean[] used) {
        if (length == nums.length) {
            set.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++)
        {
            if(!used[i])
            {
                path.add(nums[i]);
                used[i] = true;

                backtrack(nums,  path, length+1, used);

                path.remove(path.size()-1);
                used[i] = false;
            }
        }
    }

}
