package com.company;

public class Reverse_Words_in_String {
    public String reverseWords(String s) {
        //1.remove
        StringBuilder stringBuilder = removespace(s);
        //stem.out.println(stringBuilder);

        reverseWhole(stringBuilder,0 , stringBuilder.length()-1);

        //stem.out.println(stringBuilder);
        reverseWord(stringBuilder);
        return stringBuilder.toString();
    }

    StringBuilder removespace(String s )
    {
        StringBuilder stringBuilder = new StringBuilder();
        int l =0 ;
        int r= s.length()-1;
        while(l < s.length() && s.charAt(l) == ' ')
        {
            l++;
        }
        while(r >=  0 && s.charAt(r) == ' ')
        {
            r--;
        }

        while(l <= r)
        {
            char c= s.charAt(l);
            if(c != ' ' )
            {
                stringBuilder.append(c);
            }else if(stringBuilder.charAt(stringBuilder.length()-1) != ' ')
            {
                stringBuilder.append(c);
            }
            l++;
        }
        return stringBuilder;
    }

    void reverseWhole(StringBuilder stringBuilder, int l, int r)
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

    void reverseWord(StringBuilder stringBuilder)
    {
        int l = 0;
        int length = stringBuilder.length();

        for(int r = 0;r<length;r++)
        {
            if(stringBuilder.charAt(r) == ' ')
            {
                reverseWhole(stringBuilder, l , r-1);
                l= r +1;
            }
        }
        reverseWhole(stringBuilder, l , length-1);
    }

}
