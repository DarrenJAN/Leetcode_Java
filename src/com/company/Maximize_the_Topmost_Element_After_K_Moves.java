package com.company;

import java.util.PriorityQueue;

public class Maximize_the_Topmost_Element_After_K_Moves {
    public int maximumTop(int[] nums, int k) {
        if(k == 1 && nums.length == 1)
            return -1;
        if(nums.length == 0)
            return -1;
        if(k == 1)
            return nums[1];
        if(nums.length == 1)
        {
            if(k % 2 == 0)
                return nums[0];
            else
                return -1;
        }
        if( k == 0)
            return nums[0];


        PriorityQueue<Integer> pq = new PriorityQueue<>( (a, b)-> (b-a));


        int i =0;
        while(k > 1)
        {
            if(i < nums.length)
            {
                //System.out.println(nums[i]);
                pq.add(nums[i]);
                i++;
            }else
                break;

            k--;
        }

        if(i == nums.length)
            return pq.peek();
        if(i == nums.length -1)
        {
           return pq.peek();
        }
        if(nums[i+1] > pq.peek())
            return nums[i+1];
        else
            return pq.peek();

    }

}
