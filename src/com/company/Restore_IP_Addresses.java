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


    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses_2(String s) {
        backtrack_2(new ArrayList<>(), 0 , s);
        return res;
    }

    public void backtrack_2(List<String> path, int start, String s )
    {
        if(path.size() == 4 && start == s.length()) {
            StringBuilder sb = new StringBuilder();
            for (String str : path)
            {
                sb.append(str);
                sb.append('.');
            }
            res.add(sb.substring(0, sb.length()-1).toString());
        }else if(path.size() == 4)
            return;

        for(int i = start; i< s.length();i++)
        {
            String cur = s.substring(start,i+1);
            if(cur.length() > 1 && cur.charAt(0) == '0')
                continue;
            if(cur.length() >= 4)
                continue;
            int cur_val = Integer.valueOf(cur);
            if( cur_val <= 255 && cur_val >= 0 )
            {
                path.add(cur);
                backtrack_2(path, i+1, s);
                path.remove(path.size()-1);
            }
        }
    }
}
