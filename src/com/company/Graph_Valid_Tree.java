package com.company;

import java.util.ArrayList;
import java.util.List;

public class Graph_Valid_Tree {
    boolean result = true;

    public boolean validTree(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0;i< n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i =0;i< edges.length;i++)
        {
            int from = edges[i][0];
            int to = edges[i][1];

            adj.get(from).add(to);
            adj.get(to).add(from);
        }


        result = dfs(visited, adj, 0, -1);
        if(result == false)
            return false;
        for(int i =0;i<visited.length;i++)
        {
            if(visited[i] == false )
                return false;
        }

        return true;

    }

    public boolean dfs(boolean[] visited, List<List<Integer>> adj, int cur_node, int neighbor )
    {
        visited[cur_node] = true;

        List<Integer> neighbors = adj.get(cur_node);
        for(int i = 0;i< neighbors.size();i++)
        {
            int cur_neighbor = neighbors.get(i);
            if(cur_neighbor != neighbor)
            {
                if(visited[cur_neighbor] == true)
                    return false;
                boolean result = dfs(visited, adj, cur_neighbor, cur_node);
                if(result == false)
                    return false;
            }
        }
        return true;

    }

}
