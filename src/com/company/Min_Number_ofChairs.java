package com.company;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Min_Number_ofChairs {
    private static int minChairs(int[] S, int[] E) {
        int[][] guest = new int[S.length][2];
        for(int i =0;i<S.length;i++)
        {
            guest[i][0] = S[i];
            guest[i][1] = E[i];
        }

        Arrays.sort(guest, (a,b)-> (a[0]- b[0]));

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(guest[0][1]);

        for(int i = 1;i< guest.length;i++)
        {
            int pre = priorityQueue.peek();

            if(guest[i][0] >= pre)
            {
                priorityQueue.poll();
            }

            priorityQueue.add(guest[i][1]);
        }
        return priorityQueue.size();
    }
}
