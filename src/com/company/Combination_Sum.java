package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combination_Sum {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> path = new ArrayList<>();
        backtrack(candidates, target, 0, path, 0);
        return result;
    }

    public void backtrack(int[] candidates, int target, int sum, List<Integer> path, int pos)
    {
        if( sum == target)
        {
            result.add(new ArrayList<>(path));
            return;
        }else if(sum > target)
            return;

        for(int i = pos; i < candidates.length;i++)
        {
            path.add(candidates[i]);
            backtrack(candidates, target, sum + candidates[i], path, i);
            path.remove(path.size()-1);
        }

    }
}
