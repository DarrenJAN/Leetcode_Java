package com.company;

public class Minimum_Time_to_Complete_Trips {
    public long minimumTime(int[] time, int totalTrips) {
        long left = 0;
        long right = time[0];

        for (int t: time)
            right = Math.min(t, right);
        right = right * totalTrips;


        while( left <= right)
        {
            long cur_trips = 0;
            long mid = (right - left) /2 + left;
            for(int t : time)
            {
                cur_trips += mid / t;
            }

            if(cur_trips < totalTrips)
                left = mid +1;
            else
                right = mid -1;
        }
        return left;

    }

}
