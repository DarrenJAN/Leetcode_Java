package com.company;

import java.util.Stack;

public class Daily_Temperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for(int i = 0;i < temperatures.length;i++)
        {

            while(! stack.isEmpty() && temperatures[i] > temperatures[stack.peek()])
            {
                int last = stack.pop();
                result[last] = i - last;
            }
            stack.add(i);
        }
        return result;
    }

}
