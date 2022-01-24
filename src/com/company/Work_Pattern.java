package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Work_Pattern {
    public boolean wordPattern(String pattern, String s) {
        String[] strings = s.split(" ");

        if(pattern.length() != strings.length)
            return false;

        HashMap<Character, String> hashMap = new HashMap<>();
        Set<String> set = new HashSet<>();

        for(int i = 0 ; i< pattern.length();i++)
        {
            char cur_char = pattern.charAt(i);
            String cur_string = strings[i];
            if(!hashMap.containsKey(cur_char))
            {
                if(set.contains(cur_string))
                    return false;
                else
                {
                    set.add(cur_string);
                    hashMap.put(cur_char, cur_string);
                }
            }
            else {
                if(!hashMap.get(cur_char).equals(cur_string))
                {
                    return false;
                }
            }
        }

        return true;
    }
}
