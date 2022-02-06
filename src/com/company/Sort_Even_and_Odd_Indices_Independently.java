package com.company;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Sort_Even_and_Odd_Indices_Independently {
    public int[] sortEvenOdd(int[] nums) {
        int len = nums.length;
        Integer[] odds = new Integer[len/2];
        int[] evens = new int[len - len/2];

        for(int i = 0 ; i< len;i++)
        {
            if( i % 2 == 0)
            {
                evens[i] = nums[i];
            }else
                odds[i] = nums[i];
        }

        Arrays.sort(evens);
        Arrays.sort(odds, Collections.reverseOrder());

        int odds_it = 0;
        int evens_it = 0;
        for(int i = 0 ;i< len;i++)
        {
            if( i % 2 == 0)
            {
                nums[i] = evens[evens_it++];
            }else
                nums[i] = odds[odds_it++];
        }
        return nums;
    }

}
