package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Letter_Combinations_of_a_Phone_Number {
    HashMap <Character, String > hashMap = new HashMap<>();
    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        hashMap.put('2', "abc");
        hashMap.put('3', "def");
        hashMap.put('4', "ghi");
        hashMap.put('5', "jkl");
        hashMap.put('6', "mno");
        hashMap.put('7', "pqrs");
        hashMap.put('8', "tuv");
        hashMap.put('9', "wxyz");
        if(digits.equals(""))
            return result;
        backtrack(digits.toCharArray(), "", 0);
        return result;
    }

    public void backtrack(char[] chars, String str, int pos)
    {
        if(pos == chars.length -1 )
        {
            result.add(new String(str));
            return;
        }

        char c = chars[pos];
        char[] letters = hashMap.get(c).toCharArray();
        for(int i = 0; i< letters.length;i++)
        {
            str += letters[i];
            backtrack(chars, str, pos+1);
            str = str.substring(0, str.length()-1);
        }

    }

    public void backtrack_2(char[] chars, StringBuilder sb, int start)
    {
        if(sb.length() ==  chars.length)
        {
            result.add(new String(sb));
            return;
        }

        for(int i = start;i<chars.length;i++)
        {
            String cur = hashMap.get(chars[i]);
            for(int j = 0;j< cur.length(); j++)
            {
                sb.append(cur.charAt(j));
                backtrack_2(chars, sb, i+1);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

}
