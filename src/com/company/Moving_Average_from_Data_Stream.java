package com.company;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Moving_Average_from_Data_Stream {
    class MovingAverage {
        Deque<Integer> deque;
        int sum;
        int cur_size ;
        int size ;
        public MovingAverage(int size) {
            this.deque = new LinkedList<>();
            this.sum = 0;
            this.cur_size = 0;
            this.size = size;
        }

        public double next(int val) {
            if( deque.size() < size)
            {
                sum += val;
                cur_size++;
                deque.add(val);
                return sum / (cur_size * 1.0);
            }else
            {
                sum -= deque.removeFirst();
                sum += val;
                deque.addLast(val);
                return sum / (size * 1.0);
            }
        }
    }
}
