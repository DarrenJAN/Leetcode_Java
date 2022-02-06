package com.company;

import java.util.ArrayList;
import java.util.List;

public class Generate_Parentheses {
    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(0,0, n, "");
        return result;
    }
    public void backtrack(int left, int right, int n, String str)
    {
        if(str.length() == 2*n)
        {
            result.add(new String(str));
            return;
        }

        if(left >= right && left < n)
        {
            str += "(";
            backtrack(left+1, right, n, str);
            str = str.substring(0, str.length()-1);
        }

        if(right< left)
        {
            str += ")";
            backtrack(left, right+1, n, str);
            str.substring(0, str.length()-1);
        }
    }
}
