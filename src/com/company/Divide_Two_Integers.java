package com.company;

public class Divide_Two_Integers {
    public int divide(int dividend, int divisor) {
        int result = 0;
        int  negative = 1;
        if((dividend <0 && divisor>0) || (dividend>0 && divisor<0))
            negative = -1;

        if (dividend == -2147483648 && divisor == -1) {
            return 2147483647;
        }

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        while(dividend>= divisor)
        {
            dividend -= divisor;
            result ++;
        }

        return result * negative;
    }
}
