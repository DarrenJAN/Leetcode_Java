package com.company;

import java.util.Deque;
import java.util.LinkedList;

public class Sliding_Window_Maximum {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int length = nums.length;
        int[] result = new int[length - k+1];
        Deque<Integer> deque = new LinkedList<>();


        for(int i = 0;i< k;i++)
        {
            if(deque.isEmpty())
            {
                deque.addLast(i);
            }
            else
            {
                while(!deque.isEmpty() && nums[i] > nums[deque.peekLast()])
                {
                    deque.removeLast();
                }
                deque.addLast(i);
            }
        }

        int z = 0;
        result[z++] = nums[deque.peekFirst()];
        //System.out.println(result[0]);
        for(int i = k;i< length;i++)
        {
            while(!deque.isEmpty() && nums[i] > nums[deque.peekLast()])
            {
                deque.removeLast();
            }
            deque.addLast(i);

            while(!deque.isEmpty() &&  i - k >= deque.peekFirst())
            {
                deque.removeFirst();
            }

            //System.out.println(i + " " +deque.peekFirst());
            result[z++] = nums[deque.peekFirst()];
        }

        return result;
    }

}
