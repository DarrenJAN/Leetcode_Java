package com.company;

import java.util.PriorityQueue;

public class K_Closest_Points_to_Origin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b)-> (a[0]*a[0] + a[1]* a[1]) - (b[0]*b[0] + b[1]* b[1]));
        for(int i = 0;i< points.length;i++)
        {
            priorityQueue.add(points[i]);
        }

        int[][] result = new int[k][2];
        for(int i =0;i<k;i++)
        {
            int[] pos = priorityQueue.poll();
            result[i][0] = pos[0];
            result[i][1] = pos[1];
        }
        return result;
    }
}
