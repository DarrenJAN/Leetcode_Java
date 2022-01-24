package com.company;

import java.util.LinkedList;
import java.util.List;

public class Letter_Case_Permutation {
    List<String> result = new LinkedList<>();

    public List<String> letterCasePermutation(String s){
        backtrack(0, s, new StringBuilder());
        return result;
    }

    public void backtrack(int pos, String s, StringBuilder stringBuilder)
    {
        if(stringBuilder.length() == s.length())
        {
            result.add(new String(stringBuilder));
            return;
        }

        char c = s.charAt(pos);

        if(Character.isDigit(c))
        {
            stringBuilder.append(c);
            backtrack(pos+1, s, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        } else
        {
             stringBuilder.append(Character.toLowerCase(c));
             backtrack(pos+1, s, stringBuilder);
              stringBuilder.deleteCharAt(stringBuilder.length()-1);

            stringBuilder.append(Character.toUpperCase(c));
            backtrack(pos+1, s, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }
}
