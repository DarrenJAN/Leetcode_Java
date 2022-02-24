package com.company;

import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for( String str : tokens)
        {
            if(!"+-/*".contains(str))
            {
                stack.push(Integer.valueOf(str));
                continue;
            }

            char c = str.charAt(0);
            int a = stack.pop();  // second number！！！
            int b = stack.pop();  // first number ！！
            if( c == '+')
                stack.push(b+a);
            else if(c == '-')
                stack.push(b-a);
            else if(c == '*')
                stack.push(a*b);
            else if(c == '/')
            {
                int result = b / a;
                stack.push(result );
            }

        }

        return stack.pop();
    }

}
