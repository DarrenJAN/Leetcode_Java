package com.company;

import java.util.HashMap;

public class First_Unique_Character_in_a_string {
    public int firstUniqChar(String s) {
        int n = s.length();

        HashMap<Character, Integer> hashMap  = new HashMap<>();
        for(int i = 0 ; i< n;i++)
        {
            hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0)+1);
        }

        for(int i =0;i<n;i++)
        {
            if(hashMap.get(s.charAt(i)) == 1)
                return i;
        }

        return -1;
    }
}
