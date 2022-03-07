package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Minimum_Time_Difference {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> time = new ArrayList<>();
        for(int i =0;i< timePoints.size();i++)
        {
            String[] times = timePoints.get(i).split(":");
            int hour = Integer.valueOf(times[0]);
            int min = Integer.valueOf(times[1]);
            int total = hour * 60 + min;

            System.out.println(hour + " " +  min + " " + total);

            time.add(total);
        }

        Collections.sort(time);

        time.add(24*60 + time.get(0));

        int result = Integer.MAX_VALUE;

        for(int i = 1 ;i< time.size();i++)
        {
            result = Math.min(result, time.get(i) - time.get(i-1));
        }
        return result;
    }
}
