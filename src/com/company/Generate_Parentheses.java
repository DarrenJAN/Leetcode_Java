package com.company;

import java.util.ArrayList;
import java.util.List;

public class Generate_Parentheses {
    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(0,0, n, new StringBuilder());
        return result;
    }
    public void backtrack(int left, int right, int n, StringBuilder stringBuilder)
    {
        if(stringBuilder.length() == n*2)
        {
            result.add(new String(stringBuilder));
            return;
        }

        if(left  < n )
        {
            backtrack(left+1, right, n, stringBuilder.append('('));
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }

        if(left >  right)
        {
            backtrack(left, right+1,n , stringBuilder.append(')'));
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }
}
