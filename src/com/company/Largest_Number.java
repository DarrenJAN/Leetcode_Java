package com.company;

import java.util.Arrays;

public class Largest_Number {
    public String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for(int i = 0; i< nums.length;i++)
        {
            strings[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strings, (a,b)->(b.compareTo(a)));

        StringBuilder stringBuilder = new StringBuilder();
        for(String str: strings)
            stringBuilder.append(str);

        return stringBuilder.toString();

    }
}
