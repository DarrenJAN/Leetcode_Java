package com.company;

import java.util.ArrayList;
import java.util.List;

public class Sequential_Digits {
    public List<Integer> sequentialDigits(int low, int high) {
        String all = "123456789";
        String l = String.valueOf(low);
        String h = String.valueOf(high);
        List<Integer> result = new ArrayList<>();
        int len = l.length();
        for(int i = len; i<=h.length();i++)
        {
            for(int j = 0; j  + i < all.length();j++)
            {
                int end =  j + i -1 ;
                String cur = all.substring(j, end+1);
                int cur_value = Integer.valueOf(cur);
                if( cur_value>= low && cur_value <= high)
                    result.add(cur_value);
                else if(cur_value > high)
                    break;
            }
        }
        return result;
    }

}
