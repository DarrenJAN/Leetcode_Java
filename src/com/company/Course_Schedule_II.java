package com.company;

import java.util.*;

public class Course_Schedule_II {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        int[] indegree = new int[numCourses];
        int[] topologicalOrder = new int[numCourses];

        for(int i = 0;i<prerequisites.length;i++)
        {
            int cur_course = prerequisites[i][0];
            int pre = prerequisites[i][1];

            if(hashMap.containsKey(pre))
                hashMap.get(pre).add(cur_course);
            else
            {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(cur_course);
                hashMap.put(pre, tmp);
            }

            indegree[cur_course] ++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i<numCourses;i++){
            if(indegree[i] == 0)
                queue.add(i);
        }

        int i =0;
        while(! queue.isEmpty())
        {
            int node = queue.poll();
            topologicalOrder[i] = node;
            i++;

            if(hashMap.containsKey(node))
            {
                for(Integer neighbor : hashMap.get(node))
                {
                    indegree[neighbor] --;

                    if(indegree[neighbor] == 0)
                        queue.add(neighbor);
                }
            }
        }

        if(i == numCourses)
            return topologicalOrder;

        return new int[0];
    }
}
