package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Find_K_Pairs_with_Smallest_Sums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b) -> (a[3] - b[3]));

        for(int i = 0; i<nums1.length;i++)
        {
            priorityQueue.add(new int[]{0, nums1[i], nums2[0], nums1[i]+nums2[0]});
        }

        for(int i = 0;i< k;i++)
        {
            if(!priorityQueue.isEmpty())
            {
                int[] cur = priorityQueue.poll();
                List<Integer> tmp = new ArrayList<>();
                tmp.add(cur[0]);
                tmp.add(cur[1]);
                result.add(tmp);
                if(cur[0] < nums2.length-1)
                {
                    priorityQueue.add(new int[]{cur[0]+1, cur[1], nums2[cur[0]+1], cur[1]+nums2[cur[0]+1]});
                }
            }else
                break;
        }
        return result;
    }
}
