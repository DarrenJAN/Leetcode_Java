package com.company;

import java.util.*;

public class Merge_Intervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        List<int[] > result = new ArrayList<>();

        for(int[] interval: intervals)
        {
            if(result.isEmpty())
                result.add(interval);
            else
            {
                int[] top = result.get(result.size()-1);
                if(top[1] < interval[0])
                    result.add(interval);
                else
                {
                    result.remove(result.size()-1);
                    int[] cur_new = new  int[] {top[0], Math.max(top[1], interval[1])};
                    result.add(cur_new);
                }
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
