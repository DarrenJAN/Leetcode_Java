package com.company;

public class Implement_strStr {
    public int strStr(String haystack, String needle) {
        if(needle == "")
            return 0;
        int n = haystack.length();
        int right = 0;
        int right_length = needle.length();
        int left = 0;

        for(int i =0;i<n;i++)
        {
            if(needle.charAt(0) == haystack.charAt(i))
            {
               if(haystack.substring(i, i+right_length).equals(needle))
                   return i;
            }
        }

        return -1;


    }
}
