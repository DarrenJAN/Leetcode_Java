package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Number_of_Connected_Components_in_Undirected_Graph {
    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        int result = 0;
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0;i< n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i = 0;i<edges.length;i++)
        {
            int from = edges[i][0];
            int to = edges[i][1];

            adj.get(from).add(to);
            adj.get(to).add(from);
        }

        for(int i =0;i<adj.size();i++)
        {
            if(! visited[i])
            {
                dfs(visited, adj, i);
                result++;
            }

        }
        return result;

    }

    public void dfs(boolean[] visited, List<List<Integer>> adj, int pos)
    {
        visited[pos] = true;

        List<Integer> to = adj.get(pos);
        for(int i = 0;i<to.size();i++)
        {
            int cur_to = to.get(i);
            if(visited[cur_to] == false)
            {
                dfs(visited, adj, cur_to);
            }
        }

    }

}
