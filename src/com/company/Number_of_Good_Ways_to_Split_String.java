package com.company;

import java.util.HashMap;
import java.util.HashSet;

public class Number_of_Good_Ways_to_Split_String {
    public int numSplits(String s) {
        int length = s.length();
        if(length <= 1)
            return 0;

        HashMap<Character, Integer> right = new HashMap<>();
        HashMap<Character, Integer> left = new HashMap<>();
        int count = 0;

        for(Character c: s.toCharArray())
        {
            right.put(c, right.getOrDefault(c, 0)+1);
        }
        for(Character c: s.toCharArray())
        {
            right.put(c, right.get(c)-1);
            if(right.get(c) <= 0)
                right.remove(c);

            left.put(c, left.getOrDefault(c, 0)+1);

            if(right.size() == left.size() )
                count++;
        }
        return count;
    }
}
