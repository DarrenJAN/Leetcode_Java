package com.company;

public class Excel_Sheet_Column_Number {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        for(int i=0;i< columnTitle.length();i++)
        {
            char cur = columnTitle.charAt(i);
            int cur_num = cur - 'A' +1;
            result = 26 * result + cur_num;
        }
        return result;
    }
}
