package com.company;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Minimum_Remove_to_Make_Valid_Parentheses {

    public String minRemoveToMakeValid(String s) {
        StringBuilder result = helper(s, '(', ')');
        result = helper(result.reverse(), ')', '(');

        return result.toString();
    }

    public StringBuilder helper(String s, char left, char right)
    {
        int l= 0;
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0 ;i< s.length();i++)
        {
            char cur = s.charAt(i);
            if(cur == left)
            {
                l++;
            }else if(cur == right)
            {
                if(l == 0)
                    continue;
                else
                    l--;
            }

            stringBuilder.append(cur);
        }
        return stringBuilder;
    }
}
