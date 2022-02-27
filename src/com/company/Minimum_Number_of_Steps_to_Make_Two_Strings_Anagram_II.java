package com.company;

import java.util.HashMap;

public class Minimum_Number_of_Steps_to_Make_Two_Strings_Anagram_II {
    public int minSteps(String s, String t) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int steps = 0;
        for(int i =0;i<s.length();i++)
        {
            char c = s.charAt(i);
            hashMap.put(c, hashMap.getOrDefault(c, 0) +1);
        }

        for(int i =0 ;i<t.length();i++)
        {
            char c = t.charAt(i);
            if(hashMap.containsKey(c))
            {
                hashMap.put(c, hashMap.get(c)-1);
                if(hashMap.get(c) == 0)
                    hashMap.remove(c);
            }else
            {
                steps++;
            }
        }

        for(Character c: hashMap.keySet())
        {
            steps += hashMap.get(c);
        }

        return steps;
    }
}
