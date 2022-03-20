package com.company;

public class Repeated_Substring_Pattern {
    public boolean repeatedSubstringPattern(String s) {
        int length = s.length();
        int[] next = new int[length];
        getnext(next, s);

        if(length > 1)
        {
            if(next[length -1] != -1 && length % (length - (next[length-1] + 1)) == 0 )
                return true;
            else
                return false;
        }
        return false;

    }

    void getnext(int[] next, String s)
    {
        next[0] = -1;
        int j = -1;
        for(int i = 1; i < s.length();i++)
        {
            while( j >= 0 && s.charAt(i) != s.charAt(j+1))
                j = next[j];

            if(s.charAt(i) == s.charAt(j+1))
                j++;
            next[i] = j ;
        }
    }
}
