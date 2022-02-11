package com.company;

public class String_to_Integer_atoi {
    public int myAtoi(String s) {
        int result = 0;
        int len = s.length();
        int negative = 1;

        int index = 0;
        while ( index < len && s.charAt(index) == ' ')
        {
            index ++;
        }

        if( index < len && (s.charAt(index) == '+' || s.charAt(index) =='-'))
        {
            negative = s.charAt(index) == '+' ? 1: -1;
            index++;
        }

        while(index < len && Character.isDigit(s.charAt(index)))
        {

            int di = s.charAt(index) - '0';
            if(result > Integer.MAX_VALUE / 10 || ( result == Integer.MAX_VALUE /10 && di > 7 ))
            {
                if(negative == -1)
                    return  Integer.MIN_VALUE;
                else
                    return Integer.MAX_VALUE;
            }
            result = result * 10 +   di;
            index ++;
        }

        return negative * result;
    }
}
