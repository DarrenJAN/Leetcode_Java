package com.company;

import java.util.*;

public class Time_Needed_to_Inform_All_Employees {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if(n == 1)
            return 0;

        HashMap<Integer, List<Integer>>  hashMap = new HashMap<>();

        for(int i = 0;i<manager.length;i++)
        {
            if(manager[i] == -1)
                continue;
            int mange = manager[i];
            int emplyee = i;

            if(!hashMap.containsKey(mange))
                hashMap.put(mange, new ArrayList<>());
            hashMap.get(mange).add(emplyee);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{headID, informTime[headID]});
        int maxtime = 0;
        while(! queue.isEmpty())
        {
            int[] top = queue.poll();
            maxtime = Math.max(top[1], maxtime);
            int topTime = top[1];
            int head = top[0];

            if(hashMap.containsKey(head))
            {
                List<Integer> ems = hashMap.get(head);
                for(Integer em : ems)
                {
                    int[] cur_em = new int[]{em, topTime + informTime[em]};
                    queue.add(cur_em);
                }
            }

        }
        return maxtime;
    }
}
