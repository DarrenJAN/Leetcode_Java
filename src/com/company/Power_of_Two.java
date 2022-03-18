package com.company;

public class Power_of_Two {
    public boolean isPowerOfTwo(int n) {
        if(n == 1)
            return true;
        if( n == 0)
            return false;
        if(n % 2 != 0)
            return false;

        int i =1;
        while(i < n)
        {
            i = i * 2;
        }
        return i == n;
    }
}
