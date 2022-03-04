package com.company;

import java.util.List;
import java.util.Stack;

public class Exclusive_Time_of_Functions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<int[]> stack = new Stack<>();

        for(String str : logs)
        {
            String[] cur_strs = str.split(":");
            int id = Integer.valueOf(cur_strs[0]);
            int time = Integer.valueOf(cur_strs[2]);


            int[] last = {0,0,0};
            if(cur_strs[1].equals("start"))
            {
                stack.push(new int[]{id, 0, time});
            }else
            {
                last = stack.peek();
                int fn_diff=  time - last[2] +1;
                int time_diff = fn_diff - last[1];

                result[id] += time_diff;
                stack.pop();
                if(stack.size() > 0)
                {
                    int[] l= stack.peek();
                    l[1] +=fn_diff;
                }
            }
            System.out.println(id + " " + cur_strs[1] + " " + time + " " + last[0] + " "+ last[2]);

        }

        return result;
    }
}
