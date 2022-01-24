package com.company;

import java.util.Queue;
import java.util.Stack;

public class Valid_Parentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i<s.length();i++)
        {
            char shouldbe ;
            char cur = s.charAt(i);
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
            {
                stack.push(s.charAt(i));
            }
            else if(cur == ')')
            {
                if(stack.isEmpty() || stack.pop() != '(')
                    return false;
            }
            else if( cur == '}')
            {
                if(stack.isEmpty() || stack.pop() != '{')
                    return false;
            }
            else if(cur == ']')
            {
                if(stack.isEmpty() || stack.pop() != '[')
                    return false;
            } else
            {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
