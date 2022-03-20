package com.company;

public class Reverse_String_II {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();

        for(int i = 0;i< s.length(); i+= 2*k)
        {
            int j = 0;

            int l = i;
            int r = i+ k -1;
            while( l < r)
            {
                char tmp = chars[r];
                chars[r] =  chars[l];
                chars[l] = tmp;
                l++;
                r--;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(char c :chars)
            stringBuilder.append(c);

        return stringBuilder.toString();


    }

}
