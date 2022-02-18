package com.company;

public class Pow {
    public double myPow(double x, int n) {
        if(n == 1)
            return x;
        else if(n == 0)
            return 1;
        else if(n < 0)
            return myPow(1/x, -n);
        else
        {
            double xx = x * x;
            if(n % 2 == 0)
                return myPow(xx, n/2);
            else
                return myPow(xx, n/2) * x;
        }
    }

    public double myPow_2(double x, int n) {
        if(n == 1)
            return x;
        else if(n == 0)
            return 1;
        else
        {
            double half = myPow_2(x, n/2);
            if(n % 2 == 0)
                return half * half;
           else
            {
                if(n > 0 )
                    return half * half * x ;
                else
                    return half * half /x;
            }
        }

    }
}
