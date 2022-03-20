package com.company;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = s.toCharArray();

        for(char c : chars)
        {

            if(stack.isEmpty())
                stack.push(c);
            else
            {
                if(stack.peek() ==  c)
                    stack.pop();
            }
        }

        for(Character c: stack)
        {
            stringBuilder.append(c);
        }

        return  stringBuilder.toString();
    }
}
