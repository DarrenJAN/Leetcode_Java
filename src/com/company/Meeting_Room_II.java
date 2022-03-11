package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Meeting_Room_II {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(intervals[0][1]);

        for(int i =1;i< intervals.length;i++)
        {
            int pre = priorityQueue.peek();
            int[] cur = intervals[i];

            if(cur[0] >= pre)
            {
                priorityQueue.poll();
            }

            priorityQueue.add(cur[1]);
        }
        return priorityQueue.size();
    }
}
