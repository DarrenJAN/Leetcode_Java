package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Kth_Largest_Element_in_an_Array {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b)->  b- a);
        for(int i =0; i<nums.length;i++)
        {
            priorityQueue.add(nums[i]);
        }

        int result = 0;
        while(k > 0)
        {
            result = priorityQueue.poll();
            k--;
        }
        return result;
    }
}
