package com.company;

import java.util.Stack;

public class Count_Binary_Substrings {
    public int countBinarySubstrings(String s) {

        int pre_len = 0;
        int cur_len = 1;
        int result = 0;

        for(int i = 1;i< s.length();i++)
        {
            if(s.charAt(i) != s.charAt(i-1))
            {
                result += Math.min(cur_len, pre_len);
                pre_len = cur_len;
                cur_len  = 1 ;
            }else
            {
                cur_len++;
            }
        }
        return  result + Math.min(cur_len, pre_len);
    }
}
