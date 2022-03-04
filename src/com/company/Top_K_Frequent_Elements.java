package com.company;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Top_K_Frequent_Elements {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> (b[1] - a[1]));

        for(int num : nums)
        {
            hashMap.put(num, hashMap.getOrDefault(num, 0)+1);
        }

        for(Integer key: hashMap.keySet())
        {
            priorityQueue.add(new int[]{key, hashMap.get(key)});
        }

        for(int i = 0;i<k;i++)
        {
            result[i] = priorityQueue.poll()[0];
        }

        return  result;
    }
}
