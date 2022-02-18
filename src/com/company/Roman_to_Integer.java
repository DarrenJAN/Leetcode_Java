package com.company;

import java.util.HashMap;
import java.util.HashSet;

public class Roman_to_Integer {
    HashMap<String, Integer> values = new HashMap<>();

    public int romanToInt(String s) {
        values.put("M", 1000);
        values.put("D", 500);
        values.put("C", 100);
        values.put("L", 50);
        values.put("X", 10);
        values.put("V", 5);
        values.put("I", 1);

        int n = s.length();
        int total = 0;
        for(int i = 0 ; i< n;i++)
        {
            if(i != n- 1)
            {
                String f = s.substring(i, i+1);
                String l = s.substring(i+1, i+2);
                if(values.get(f) < values.get(l))
                {
                    total += values.get(l) - values.get(f);
                    i ++;
                }else
                {
                    total  += values.get(f);
                }
            }
            else
            {
                String f = s.substring(i, i+1);
                total  += values.get(f);
            }
        }
        return total;
    }
}
