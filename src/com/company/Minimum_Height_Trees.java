package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Minimum_Height_Trees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();

        if(n < 2)
        {
            for(int i =0;i<n;i++)
            {
                result.add(i);
            }
            return result;
        }

        List<List<Integer>> adj = new ArrayList<>();

        for(int i =0;i<n;i++)
            adj.add(new ArrayList<>());

        int[] indegree = new int[n];

        for(int i = 0;i<edges.length;i++)
        {
            int from  = edges[i][0];
            int to = edges[i][1];

            adj.get(from).add(to);
            adj.get(to).add(from);
            indegree[from]++;
            indegree[to]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i= 0;i<n;i++)
        {
            if( indegree[i] == 1)
                queue.add(i);
        }


       while( !queue.isEmpty())
       {
           int size = queue.size();
           result = new ArrayList<>();

           for(int i =0;i<size;i++)
           {
               int node = queue.poll();
               indegree[node] --;
               result.add(node);

               for( Integer children : adj.get(node))
               {
                   indegree[children]--;
                   if(indegree[children] == 1)
                       queue.add(children);
               }
           }
       }

        return result;
    }
}
