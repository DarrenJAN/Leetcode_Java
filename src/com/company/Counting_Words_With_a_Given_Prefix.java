package com.company;

public class Counting_Words_With_a_Given_Prefix {
    public int prefixCount(String[] words, String pref) {
        int result = 0;
        for(int i = 0;i< words.length;i++)
        {
            String cur_str = words[i];
            if(helper(cur_str, pref))
                result++;
        }
        return result;
    }
    public boolean helper(String word1, String word2)
    {
        int w1=0;
        if(word2.length() >word1.length())
            return false;

        for(int i =0;i< word2.length();i++)
        {
            if(word1.charAt(w1) != word2.charAt(i))
            {
                return false;
            }else
                w1++;
        }
        return  true;
    }
}
