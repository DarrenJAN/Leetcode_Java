package com.company;

public class Reverse_String {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;
        while(left < right)
        {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;

            left ++;
            right --;
        }
    }
}
