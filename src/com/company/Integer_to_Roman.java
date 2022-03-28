package com.company;

import java.util.HashMap;

public class Integer_to_Roman {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder stringBuilder = new StringBuilder();
       for(int i = 0; i< values.length;i++)
       {
           int cur_val = values[i];
           while( num >= cur_val)
           {
               stringBuilder.append(symbols[i]);
               num -= cur_val;
           }
       }
        return stringBuilder.toString();
    }
}
