package com.company;

public class Custom_Sort_String {
    public String customSortString(String order, String s) {
        char[] chars = new char[26];

        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            chars[c - 'a'] ++;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i< order.length();i++)
        {
            char  c = order.charAt(i);
            for(int j = 0 ; j< chars[c - 'a'];j++)
            {
                stringBuilder.append(c);
            }
            chars[c-'a'] = 0;
        }

        for(char c = 'a';c <= 'z'; c++)
        {
            for(int j = 0;j< chars[c - 'a'];j++)
            {
                stringBuilder.append(c);
            }
        }

        return stringBuilder.toString();
    }
}
