package com.company;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class Last_Stone_Weight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num: stones)
            max_heap.add(num);

        while(max_heap.size() > 1 )
        {
            int first = max_heap.poll();
            int second = max_heap.poll();

            if(first == second )
                continue;
            else
                max_heap.add(first - second);
        }

        return max_heap.size() == 0 ? 0:max_heap.poll();
    }
}
