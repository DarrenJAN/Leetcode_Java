package com.company;

import java.util.HashMap;
import java.util.Map;

public class Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        int left = 0 ;
        HashMap<Character, Integer> map = new HashMap<>();
        int result = 0;
        for(int i = 0; i< s.length();i++)
        {
            char cur_char = s.charAt(i);
            if(map.containsKey(cur_char))
            {
                left = Math.max(left, map.get(cur_char) +1);
                //System.out.println(left +" "+ i);
            }
            result = Math.max(result, i - left +1);
            map.put(cur_char, i);
        }
        return result;

    }

    public static void main(String[] args) {

    }
}
