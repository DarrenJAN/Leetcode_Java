package com.company;

import java.util.LinkedList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        dfs(1,n,k, new LinkedList<>(), result);
        return result;
    }

    public void dfs(int pos, int n, int k, List<Integer> path, List<List<Integer>> result)
    {
        if(path.size() == k)
        {
            List<Integer> newPath=  new LinkedList<>(path);
            result.add(newPath);
            return;
        }

        for(int i = pos; i<=n; i++)
        {
            path.add(i);
            dfs(i+1, n, k, path, result);
            path.remove(path.size() -1);
        }
    }

}
