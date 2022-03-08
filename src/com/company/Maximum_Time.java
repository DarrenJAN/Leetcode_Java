package com.company;

public class Maximum_Time {
    public String giveMeMaxTime(String tim){
        char[] chars =tim.toCharArray();

        if(chars[4] == '?')
            chars[4] = '9';
        if(chars[3] == '?')
            chars[3] = '5';

        if(chars[0] == '?')
        {
            if(chars[1] == '?')
            {
                chars[0] = '2';
                chars[1] = '3';
            }else
            {
                if(chars[1] - '0' > 3)
                    chars[0] = '1';
                else
                    chars[0] = '2';
            }
        }

        if(chars[1] == '?')
        {
            if(chars[0] -'0' > 1)
                chars[1] = '3';
            else
                chars[1] = '9';
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(char c : chars)
            stringBuilder.append(c);

        return stringBuilder.toString();
    }
}
