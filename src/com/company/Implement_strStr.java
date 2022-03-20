package com.company;

public class Implement_strStr {
    public int strStr(String haystack, String needle) {
        if (needle == "")
            return 0;
        int n = haystack.length();
        int right = 0;
        int right_length = needle.length();
        int left = 0;

        for (int i = 0; i < n; i++) {
            if (needle.charAt(0) == haystack.charAt(i)) {
                if (haystack.substring(i, i + right_length).equals(needle))
                    return i;
            }
        }

        return -1;


    }

    public int strStr_2(String haystack, String needle) {
        if(needle.length()==0){
            return 0;
        }
        int length = needle.length();

        int[] next =new int[length];
        getnext(next, needle);
        int j =-1;
        for(int i  = 0;i< haystack.length();i++)
        {
            while(j >= 0 && haystack.charAt(i) != needle.charAt(j+1))
            {
                j = next[j];
            }

            if(haystack.charAt(i) == needle.charAt(j+1))
                j++;

            if(j == needle.length()-1)
                return i - j;
            //System.out.println(j);
        }
        return -1;
    }

    public void getnext(int[] next, String s)
    {
        next[0] = -1;
        int j = -1;

        for(int i = 1; i< s.length();i++)
        {
            while(j >= 0 && s.charAt(i) != s.charAt(j+1))
                j = next[j];

            if(s.charAt(i) == s.charAt(j+1))
                j++;
            next[i] = j;
        }
    }

}
