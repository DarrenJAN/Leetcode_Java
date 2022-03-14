package com.company;

import java.util.*;

public class All_Paths_from_Source_Lead_to_Destination {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> lists = new ArrayList<>();
        for(int i =0;i<n;i++)
            lists.add(new ArrayList<>());
        int[] indegree = new int[n];
        for(int i =0;i<edges.length;i++)
        {
            int from = edges[i][0];
            int to = edges[i][1];

            lists.get(from).add(to);
            indegree[to]++;
        }

        boolean [] vis = new boolean[n];
        return dfs(source, lists, source, destination, vis);
    }

    public boolean dfs(int cur_num, List<List<Integer>> lists, int source, int des, boolean[] vis)
    {
        if(cur_num == des && lists.get(des).size() == 0)
            return true;
        if(vis[cur_num] == true || lists.get(cur_num).size() == 0)
        {
            return false;
        }
        
        List<Integer> neighbors = lists.get(cur_num);
        for(Integer neigh : neighbors)
        {
            if(neigh != des && vis[neigh] == true)
            {
                return false;
            }

            else
            {
                vis[cur_num] = true;
                if( !dfs(neigh, lists, source, des, vis))
                    return false;
                vis[cur_num] =false;
            }
        }
        return true;
    }
}
