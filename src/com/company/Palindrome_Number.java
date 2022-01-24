package com.company;

public class Palindrome_Number {
    public boolean isPalindrome(int x) {
        if( x < 0 || (x %10 == 0 && x !=0))
            return false;

        int second_half_reverse = 0;
        while( second_half_reverse < x)
        {
            second_half_reverse = second_half_reverse * 10 + x%10;
            x = x / 10;
        }

        if(second_half_reverse == x || second_half_reverse/10 == x )
            return true;
        else
            return false;
    }
}
