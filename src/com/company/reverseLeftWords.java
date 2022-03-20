package com.company;

public class reverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        int length = s.length();
        n =  n % length;

        StringBuilder stringBuilder = new StringBuilder(s);
        reverse(stringBuilder,0, n-1);
        reverse(stringBuilder, n, length-1);
        reverse(stringBuilder, 0, length-1);
        return stringBuilder.toString();
    }

    void reverse(StringBuilder stringBuilder, int l , int r)
    {
        while(l < r)
        {
            char tmp = stringBuilder.charAt(l);
            stringBuilder.setCharAt(l, stringBuilder.charAt(r));
            stringBuilder.setCharAt(r, tmp);
            l++;
            r--;
        }
    }
}
