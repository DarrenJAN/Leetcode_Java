package com.company;

import java.util.Stack;

public class Count_Collisions_on_Road {
    public int countCollisions(String directions) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        char[] s = directions.toCharArray();
        for(char c : s)
        {
            if(stack.isEmpty())
            {
                stack.push(c);
            }else if( c == 'R')
            {
                stack.push(c);
            }else if(c == 'L')
            {
                char last = stack.peek();
                if(last == 'R'){
                    stack.pop();

                    count+=2;
                    while(!stack.isEmpty() && stack.peek() == 'R')
                    {
                        stack.pop();
                        count++;
                    }
                    stack.push('S');
                }else if(last == 'S'){
                    count++;
                    stack.push('S');
                }else
                {
                    stack.push('L');
                }
            }else if( c == 'S')
            {
                char last = stack.peek();
                if(last == 'S')
                {
                    stack.push(c);
                }else if(last == 'L')
                    stack.push(c);
                else
                {
                    while(!stack.isEmpty() && stack.peek() == 'R')
                    {
                        stack.pop();
                        count++;
                    }
                    stack.push(c);
                }
            }
        }
        return count;

    }
}
