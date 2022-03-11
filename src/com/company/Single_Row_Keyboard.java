package com.company;

public class Single_Row_Keyboard {
    public int calculateTime(String keyboard, String word) {
        int[] key = new int[26];
        int count =0;
        for(int i = 0;i< keyboard.length();i++)
        {
            char cur_char = keyboard.charAt(i);
            int value = cur_char - 'a';
            key[value] =  i;
        }

        int cur_index = 0;
        for(int i = 0;i< word.length();i++)
        {
            char cur_char = word.charAt(i);
            int value = cur_char - 'a';

            count += (Math.abs(key[value] - cur_index));
            cur_index  = key[value];
        }
        return count;
    }
}
