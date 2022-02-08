package com.company;

import java.util.ArrayList;
import java.util.List;

public class Interval_List_Intersections {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[] > result = new ArrayList<>();
        int f_len = firstList.length;
        int s_len = secondList.length;

        if( f_len == 0 || s_len == 0 )
            return f_len == 0? firstList : secondList;

        int i = 0, j = 0;
        while ( i < f_len && j < s_len)
        {
            int low = Math.max(firstList[i][0], secondList[j][0]);
            int high = Math.min(firstList[i][1], secondList[j][1]);

            if( low <= high)
            {
                result.add(new int[] {low, high});
            }

            if( firstList[i][1] <= secondList[j][1])
            {
                i++;
            }else
            {
                j++;
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
