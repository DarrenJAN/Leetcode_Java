package com.company;

import java.util.Arrays;

public class Maximum_Units_on_a_Truck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        int units = 0;
        int cur_index = 0;
        while(truckSize > 0)
        {
            int cur_size = Math.min(truckSize, boxTypes[cur_index][0]);
            units += cur_size * boxTypes[cur_index][1];
            truckSize -= cur_size;
            cur_index++;
            if(cur_index >= boxTypes.length)
                break;
        }
        return units;
    }
}
