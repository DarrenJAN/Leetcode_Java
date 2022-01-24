package com.company;

import java.util.LinkedList;
import java.util.List;

public class Plus_One {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for(int i =0 ;i<len;i++)
        {
            if(digits[len - i -1] == 9)
                digits[len-i -1] = 0;
            else
            {
                digits[len -i - 1] ++;
                return digits;
            }
        }

        digits = new int[len+1];
        digits[0] = 1;
        return digits;

    }
}
