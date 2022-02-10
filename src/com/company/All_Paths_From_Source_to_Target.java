package com.company;

import java.util.ArrayList;
import java.util.List;

public class All_Paths_From_Source_to_Target {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length-1;
        if(graph[0].length == 0)
            return result;

        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, n, 0, path);
        return result;

    }

    public void dfs(int[][] graph, int n, int cur_num, List<Integer> path)
    {

        if(cur_num == n)
        {
            result.add(new ArrayList<>(path));
            return;
        }

        int[] list = graph[cur_num];
        for(int i =0;i< list.length;i++)
        {
            path.add(list[i]);
            dfs(graph, n, list[i], path);
            path.remove(path.size()- 1);
        }
    }
}
