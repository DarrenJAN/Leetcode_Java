package com.company;

public class String_Compression {
    public int compress(char[] chars) {

        int pre_num = 1;
        char pre_char = chars[0];

        int pre_char_change_index = 0;


        for(int i = 1;i< chars.length;i++)
        {
            if(chars[i] != chars[i-1])
            {
                chars[pre_char_change_index ++] = pre_char;
                if(pre_num != 1)
                {
                    String  freq = String.valueOf(pre_num);
                    for(int j = 0; j< freq.length();j++)
                        chars[pre_char_change_index++] = freq.charAt(j);
                }
                pre_num = 1;
                pre_char = chars[i];

            }else
            {
                pre_num++;
            }
        }

        chars[pre_char_change_index ++] = pre_char;
        if(pre_num != 1)
        {
            String  freq = String.valueOf(pre_num);
            for(int j = 0; j< freq.length();j++)
                chars[pre_char_change_index++] = freq.charAt(j);
        }



        return pre_char_change_index;
    }
}
