package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Number_of_Ways_to_Arrive_at_Destination {
    public int countPaths(int n, int[][] roads) {
        int edges = roads.length;

        if(edges == 1)
            return 1;

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i = 0;i<roads.length;i++)
        {
            int from = roads[i][0];
            int to = roads[i][1];

            adj.get(from).add(to);
            adj.get(to).add(from);
        }

        Queue<Integer> queue = new LinkedList<>();


    }

}
