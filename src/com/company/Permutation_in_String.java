package com.company;

import java.util.Arrays;

public class Permutation_in_String {
    public boolean checkInclusion(String s1, String s2) {
        s1 = sort(s1);

        for(int i = 0;i< s2.length()-s1.length()+1  ;i++)
        {
            String cur_string = s2.substring(i, i+ s1.length());
            if(s1.equals(sort(cur_string)))
            {
                return true;
            }
        }
        return false;
    }

    public String sort(String s)
    {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        return new String(chars);
    }

    public boolean checkInclusion_2(String s1, String s2) {
        int[] str1 = new int[26];
        int[] str2 = new int[26];

        if(s1.length() > s2.length())
            return false;

        for(int i = 0;i<s1.length();i++)
        {
            str1[s1.charAt(i) - 'a'] ++;
            str2[s2.charAt(i) - 'a'] ++;
        }

        for(int i = 0;i< s2.length() - s1.length();i++)
        {
            if(match(str1 ,str2))
                return true;

            str2[s2.charAt(i) - 'a']--;
            str2[s2.charAt(i+s1.length()) - 'a']++;

        }

        return match(str1, str2);


    }

    public boolean match(int[] s1, int[] s2)
    {
        for(int i = 0;i< s1.length;i++)
        {
            if(s1[i] != s2[i])
                return false;
        }

        return true;
    }
}
