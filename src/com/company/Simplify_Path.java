package com.company;

import java.util.Stack;

public class Simplify_Path {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] strings = path.split("/");

        for(String cur_string :strings)
        {
            if( cur_string.equals(".") || cur_string.isEmpty())
            {
                continue;
            }else if( cur_string.equals(".."))
            {
                if(!stack.isEmpty())
                {
                    stack.pop();
                }
            }else
            {
                stack.add(cur_string);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(String s: stack)
        {
            stringBuilder.append("/");
            stringBuilder.append(s);
        }
        return stringBuilder.length() == 0? "/": stringBuilder.toString();
    }
}

