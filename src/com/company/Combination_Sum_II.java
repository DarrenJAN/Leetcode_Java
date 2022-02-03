package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum_II {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, 0, new ArrayList<>());
        return result;
    }

    public void backtrack(int[] candidates, int sum, int target, int pos, List<Integer> path)
    {
        if(sum == target)
        {
            if(!result.contains(path))
                result.add(new ArrayList<>(path));
            return;
        }
        else if (sum > target)
            return;

        for(int i = pos;i<candidates.length;i++)
        {

            if(i > pos && candidates[i-1] == candidates[i])
                continue;
            path.add(candidates[i]);
            sum += candidates[i];

            backtrack(candidates, sum, target, i+1, path);

            path.remove(path.size()-1);
            sum-= candidates[i];
        }
    }

}
