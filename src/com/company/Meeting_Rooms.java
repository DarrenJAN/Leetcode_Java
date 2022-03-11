package com.company;

import java.util.Arrays;

public class Meeting_Rooms {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        for(int i = 1 ;i< intervals.length;i++)
        {
            int[] pre = intervals[i-1];
            int[] cur = intervals[i];
            if( pre[0] <=cur[0] && cur[0] < pre[1])
                return false;
        }
        return false;

    }
}
