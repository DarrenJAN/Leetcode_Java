package com.company;

import java.util.*;

public class Insert_Interval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[] > result = new LinkedList<>();
        LinkedList<int[] > tmp = new LinkedList<>();

        for(int[] interval : intervals)
            tmp.add(interval);
        tmp.add(newInterval);

        Collections.sort(tmp, new Comparator<int[]>(){
            public int compare(int[] a , int[] b){
                return a[0]-b[0];
            }
        });

        for(int i = 0;i< tmp.size();i++)
        {
            int[] cur = tmp.get(i);

            if(result.isEmpty())
                result.add(cur);
            else
            {
                int[] last = result.peekLast();
                if(last[1] < cur[0])
                    result.add(cur);
                else
                {
                    result.removeLast();
                    int[] cur_new = new  int[] {last[0], Math.max(last[1], cur[1])};
                    result.add(cur_new);
                }
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
