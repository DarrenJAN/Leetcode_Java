package com.company;

public class Flip_String_to_Monotone_Increasing {
    public int minFlipsMonoIncr(String s) {
        int flip = 0;
        int ones = 0;
        for(int i = 0;i<s.length();i++)
        {
            if(s.charAt(i) == '1')
                ones++;
            else
            {
                flip++;
                flip = Math.min(flip, ones);
            }
        }
        return flip;
    }

}
