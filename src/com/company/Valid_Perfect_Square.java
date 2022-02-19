package com.company;

public class Valid_Perfect_Square {
    public boolean isPerfectSquare(int num) {
        if(num < 2)
            return true;

        long n = num/2;
        while(n * n >= num)
        {
            if(n * n == num)
                return true;

            n = n/2;
        }
        for(;n*n <=num;n++)
        {
            if(n *n== num)
                return true;
        }
        return false;
    }
}
