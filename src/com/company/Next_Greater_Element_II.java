package com.company;

import java.util.Stack;

public class Next_Greater_Element_II {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];

        for(int i = 0;i< nums.length;i++)
        {
            while(! stack.isEmpty() && nums[i] > nums[stack.peek()])
            {
                int last = stack.pop();
                result[last] = nums[i];
            }
            stack.push(i);
        }


        for(int i = 0; i < nums.length; i++)
        {
            while( !stack.isEmpty() && nums[i] > nums[stack.peek()])
            {
                result[stack.pop()] = nums[i];
            }
        }

        while(! stack.isEmpty())
        {
            nums[stack.pop()] = -1;
        }
        return result;

    }

}
