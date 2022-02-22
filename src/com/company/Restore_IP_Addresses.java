package com.company;

import java.util.ArrayList;
import java.util.List;

public class Restore_IP_Addresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();

        if(s.length() > 12 || s.length()< 4)
            return result;

        backtrack(s,0,0,new StringBuilder(), result);
        return result;
    }

    public void backtrack(String s, int pos,int count, StringBuilder stringBuilder, List<String> result )
    {
        if(pos == s.length() && count  == 4)
        {
            result.add(new String(stringBuilder));
            return;
        }else if(count == 4 || pos == s.length())
            return;

        for(int i = pos;i<s.length();i++)
        {
            String curr = s.substring(pos,i+1);
            if(curr.length() > 1 && curr.charAt(0) == '0')
                return;
            int val = Integer.valueOf(curr);
            if(val < 0 || val > 255)
                return;

            StringBuilder tmp = new StringBuilder(stringBuilder);
            stringBuilder.append(curr);
            if(count < 3 )
                stringBuilder.append('.');

            backtrack(s, i+1, count+1, stringBuilder, result);

            stringBuilder = tmp;
        }
    }
}
