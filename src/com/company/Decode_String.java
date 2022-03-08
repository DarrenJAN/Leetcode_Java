package com.company;

import java.util.Stack;

public class Decode_String {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for(int i = 0;i< s.length();i++)
        {
            char cur_char = s.charAt(i);
            if(Character.isDigit(cur_char))
            {
                stack.push(cur_char);
            }else if(cur_char == '[')
            {
                stack.push(cur_char);
            }else if (cur_char == ']')
            {
                StringBuilder current = new StringBuilder();
                int base = 1;
                int k = 0;
                while(stack.peek() != '[')
                {
                    current.append(stack.pop());
                }
                current.reverse();
                stack.pop();

                while( Character.isDigit(stack.peek()))
                {
                    k = k + (stack.pop() -'0') * base;
                    base *= 10;
                    if(stack.isEmpty())
                        break;
                }
                for(int j= 0;j< k;j++) {
                    for (int z = 0; z < current.length(); z++)
                        stack.push(current.charAt(z));
                }
            }else {
                stack.push(cur_char);
            }
            //System.out.println(stack.peek());
        }

        while(!stack.isEmpty())
        {
            result.append(stack.pop());
        }
        return result.reverse().toString();

    }



}
