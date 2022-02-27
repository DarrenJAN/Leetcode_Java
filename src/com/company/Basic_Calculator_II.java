package com.company;

import java.util.Stack;

public class Basic_Calculator_II {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int cur_num = 0;
        int sign = 1;
        char cur_opera = '+';
        for(int i = 0;i< s.length();i++)
        {
            char c = s.charAt(i);
            if(i != s.length()-1 && Character.isWhitespace(c))
                continue;
            else if(Character.isDigit(c))
            {
                cur_num = 10 * cur_num + c -'0';
            }

            if(i == s.length() -1 || !Character.isDigit(c) )
            {
                if(cur_opera == '+')
                {
                    stack.push(+cur_num);
                }else if(cur_opera  == '-')
                {
                    stack.push(-cur_num);
                }else if( cur_opera == '*')
                {
                    int last = stack.pop();
                    stack.add(last * cur_num);
                }else
                {
                    int last = stack.pop();
                    stack.add(last / cur_num);
                }
                cur_num = 0;
                cur_opera = c;
            }

        }

        int result = 0;
        while(! stack.isEmpty())
        {
            result += stack.pop();
        }

        return result;
    }



}
