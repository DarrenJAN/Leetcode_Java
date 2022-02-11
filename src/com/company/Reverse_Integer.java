package com.company;

public class Reverse_Integer {

    boolean negative = false;
    public int reverse(int x) {
        if(x < 0 )
            negative = true;

        if(negative)
            return -1 * helper(Math.abs(x));
        else
            return helper(x);
    }

    public int helper(int x)
    {
        int result = 0;
        while(x > 0)
        {
            int tmp = x % 10;
            if( result > Integer.MAX_VALUE / 10 )
                return 0;

            result = tmp * 10 + tmp;
            x =  x / 10;

        }
        return result;
    }
}
