package com.company;

import java.util.HashMap;
import java.util.Map;

public class Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int length =s.length();
        int result= 0;
        Map<Character, Integer> index = new HashMap<>();

        while(right < length)
        {
            char c = s.charAt(right);
            if( !index.containsKey(c)){
                index.put(c, right);
                right++;
            }else if ( index.get(c) >= left && index.get(c) < right )
            {
                left = index.get(c)+1;
                index.put(c, right);
                right++;
            }else
            {
                index.put(c, right);
                right++;
            }
            result = Math.max(result, right - left +1);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
