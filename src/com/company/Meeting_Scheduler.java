package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Meeting_Scheduler {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a, b) -> (a[0]- b[0]));
        Arrays.sort(slots2, (a, b) -> (a[0]- b[0]));
        List<Integer> result = new ArrayList<>();
        int l1 = 0;
        int l2 = 0;
        while(l1 < slots1.length && l2 < slots2.length)
        {
            int[] cur1 = slots1[l1];
            int[] cur2 = slots2[l2];
            if(cur2[1] < cur1[0])
            {
                l2 ++;
            }else if(cur2[0] > cur1[1])
            {
                l1 ++;
            }
            else {
                int max_start = Math.max(cur1[0], cur2[0]);
                int min_end = Math.min(cur1[1], cur2[1]);
                if(min_end - max_start >= duration)
                {
                    result.add(max_start);
                    result.add(max_start + duration);
                    return result;
                }else
                {
                    if(cur1[1] < cur2[1])
                        l1++;
                    else
                        l2++;
                }
            }
        }
        return result;

    }
}
