package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, new ArrayList<>(), 1, k);
        return result;
    }

    public void backtrack(int n, List<Integer> path, int start, int k)
    {
        if(path.size() == k)
        {
            result.add(new ArrayList<>(path));
            return ;
        }

        for(int i = start;i<= n;i++)
        {
            path.add(i);
            backtrack(n, path, i+1, k);
            path.remove(path.size()-1);
        }
    }
}
