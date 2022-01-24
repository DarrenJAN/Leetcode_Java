package com.company;

public class Valid_Anagram {
    public boolean isAnagram(String s, String t) {
        int slength = s.length();
        int tlength = t.length();

        if( slength != tlength)
            return false;

        int[] chars = new int[26];
        for(int i = 0;i < slength;i++)
        {
            char c = s.charAt(i);
            chars[c - 'a']  ++;
        }

        for(int i =0;i<t.length();i++)
        {
            char c = t.charAt(i);
            chars[c - 'a'] --;
            if( chars[c - 'a'] < 0)
                return false;
        }

        return true;

    }

}
