package com.company;

import java.util.Arrays;

public class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int min_radius = 0;

        for(int i = 0;i< houses.length;i++)
        {
            int cur_house = houses[i];

            int l = 0;
            int r = heaters.length-1;
            int cur_min = Integer.MAX_VALUE;
            while(l <= r )
            {
                int mid = ( r - l)/2 + l;
                cur_min = Math.min(cur_min, Math.abs(cur_house - heaters[mid]));


                if(heaters[mid] == cur_house)
                {
                    break;
                }else if (cur_house < heaters[mid])
                {
                    r = mid-1;

                }else
                {
                    l = mid +1;
                }
            }
            min_radius = Math.max(min_radius, cur_min);
        }
        return min_radius;
    }

}
