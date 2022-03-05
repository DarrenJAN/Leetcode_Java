package com.company;

import java.util.ArrayList;
import java.util.List;

public class Zigzag_Conversion {
    public String convert(String s, int numRows) {
        if(numRows == 1)
            return s ;
        List<StringBuilder> list = new ArrayList<>();
        for(int i =0;i< numRows;i++)
            list.add(new StringBuilder());

        int cur_row = 0;
        boolean go_down = true;

        char[] chars = s.toCharArray();
        for(int i= 0;i< chars.length;i++)
        {
            list.get(cur_row).append(chars[i]);

            if(cur_row == 0)
            {
                go_down = true;
            }else if( cur_row == numRows-1)
                go_down = false;


            if(go_down == true)
            {
                cur_row++;
            }else
            {
                cur_row--;
            }
        }

        StringBuilder result = new StringBuilder();
        for(int i = 0;i<numRows;i++)
            result.append(list.get(i));

        return result.toString();
    }

}
