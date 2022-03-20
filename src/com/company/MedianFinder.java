package com.company;

import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> smallest ;
    PriorityQueue<Integer> biggest ;


    public MedianFinder() {
        smallest = new PriorityQueue<>( (a, b) -> (b -a));
        biggest = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(smallest.isEmpty() || smallest.peek() > num)
        {
            smallest.add(num);
        }else
            biggest.add(num);

        if(smallest.size() > biggest.size() +1)
        {
            biggest.add(smallest.poll());
        }else if(smallest.size() < biggest.size())
        {
            smallest.add(biggest.poll());
        }

    }

    public double findMedian() {
        int s_size = smallest.size();
        int b_size = biggest.size();
        if(s_size == b_size)
        {
            return smallest.peek() / 2.0 + biggest.peek() / 2.0;
        }else
        {
            return smallest.peek();
        }

    }
}
