package com.company;

import java.util.*;

public class Course_Schedule {
    HashMap<Integer, List<Integer>> hashMap = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i = 0;i<prerequisites.length;i++)
        {
            int cur_course = prerequisites[i][0];
            int pre = prerequisites[i][1];

            if(hashMap.containsKey(pre))
            {
                hashMap.get(pre).add(cur_course);
            }else
            {
                List<Integer> list = new ArrayList<>();
                list.add(cur_course);
                hashMap.put(pre ,list);
            }
        }

        boolean[] path = new boolean[numCourses];
        for (int currCourse = 0; currCourse < numCourses; ++currCourse) {
            if (isCycle(new boolean[numCourses], currCourse)) {
                return false;
            }
        }

        return true;
    }

    public boolean isCycle(boolean[] path, int cur_course)
    {
        if(path[cur_course] == true)
            return true;


        if(! hashMap.containsKey(cur_course))
            return false;

        path[cur_course] = true;
        boolean ret = false;
        List<Integer> next_course  = hashMap.get(cur_course);
        for(int i = 0 ;i< next_course.size();i++)
        {
            ret = isCycle(path, next_course.get(i));
            if( ret)
                break;
        }
        path[cur_course] = false;
        return ret;
    }

    //indegree
    HashMap<Integer, List<Integer>> hash = new HashMap<>();

    public boolean canFinish_2(int numCourses, int[][] prerequisites) {
        int edges = prerequisites.length;
        int[] indegree = new int[numCourses];


        for(int i =0 ;i<prerequisites.length;i++)
        {
            int cur = prerequisites[i][0];
            int pre = prerequisites[i][1];

            if (hash.containsKey(pre) )
                hash.get(pre).add(cur);
            else
            {
                hash.put(pre, new ArrayList<>());
                hash.get(pre).add(cur);
            }

            indegree[cur]  ++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i<indegree.length;i++)
        {
            if(indegree[i] == 0)
                queue.add(i);
        }

        while(! queue.isEmpty())
        {
            int node = queue.poll();

            if( hash.containsKey(node))
            {
                List<Integer> next_courses = hash.get(node);
                for(int i = 0;i< next_courses.size();i++)
                {
                    int next_course = next_courses.get(i);
                    indegree[next_course] --;
                    if(indegree[next_course] == 0 )
                        queue.add(next_course);
                }
            }
        }

        for(int i = 0;i<indegree.length;i++)
        {
            if(indegree[i] != 0)
                return false;
        }
        return true;
    }
}
