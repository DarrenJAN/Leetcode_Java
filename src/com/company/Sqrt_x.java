package com.company;

public class Sqrt_x {
    public int mySqrt(int x) {
        if(x <2 )
            return x;

        long num = x/2 ;
        while (num * num > x)
        {
            num = num /2;
        }
        for(; num*num <= x ;num++);

        return (int)(num-1);
    }
}
