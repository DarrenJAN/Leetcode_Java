package com.company;

import java.util.Arrays;
import java.util.PriorityQueue;

class KthLargest {
    private int k;
    private PriorityQueue<Integer> min_heap;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        min_heap = new PriorityQueue<>();

        for( int num: nums)
            min_heap.offer(num);

        while(min_heap.size() > k)
        {
            min_heap.poll();
        }
    }

    public int add(int val) {
        min_heap.add(val);
        while(min_heap.size() > k)
        {
            min_heap.poll();
        }
        return min_heap.peek();
    }
}
