package com.company;

import java.util.HashMap;
import java.util.HashSet;

public class Longest_String_Chain {
    private HashMap<String, Integer> memo = new HashMap<>();
    private HashSet<String> hashSet = new HashSet<>();

    public int longestStrChain(String[] words) {
        for(int i= 0;i< words.length;i++)
            hashSet.add(words[i]);

        int result = 0;
        for(int i = 0;i<words.length;i++)
        {
            result = Math.max(result, dfs(words[i]));
        }

        return result;

    }

    public int dfs(String word)
    {
        if(memo.containsKey(word))
            return memo.get(word);

        StringBuilder stringBuilder = new StringBuilder(word);
        int maxLength = 1;
        for(int i = 0;i<word.length();i++)
        {
            char cur_char = word.charAt(i);
            stringBuilder.deleteCharAt(i);
            String next_string = stringBuilder.toString();
            if(hashSet.contains(next_string))
            {
                int curlength =  1+ dfs(next_string);
                maxLength = Math.max(curlength, maxLength);
            }

            stringBuilder.insert(i, cur_char);

        }
        memo.put(word, maxLength);

        return maxLength;
    }
}
