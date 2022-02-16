package com.company;

import java.util.*;

public class Group_Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        int n = strs.length;
        if(n == 0)
            return result;

        HashMap<String, List<String>> hashmap = new HashMap<>();

        for(String s: strs)
        {
            char[] tmp = s.toCharArray();
            System.out.println(tmp);
            Arrays.sort(tmp);
            System.out.println(tmp);
            //String str = tmp.toString();
            String str =  String.valueOf(tmp);
            if( ! hashmap.containsKey(str))
            {
                hashmap.put(str, new ArrayList<>());
            }
            hashmap.get(str).add(s);
        }

        for(Map.Entry<String, List<String>> entry : hashmap.entrySet())
        {
            result.add(entry.getValue());
        }
        return result;
    }


    public List<List<String>> groupAnagrams_2(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        int n = strs.length;
        if(n == 0)
            return result;

        HashMap<String, List<String>> hashmap = new HashMap<>();
        for(String s: strs)
        {
            int[] count = new int[26];
            char[] chars = s.toCharArray();
            for(int i=0;i<chars.length;i++)
            {
                count[chars[i] - 'a'] ++;
            }

            StringBuilder stringBuilder = new StringBuilder();
            for(int i = 0;i<26;i++)
            {

                stringBuilder.append(count[i]);
                stringBuilder.append('#');
            }
            String key = stringBuilder.toString();
            if(!hashmap.containsKey(key))
            {
                hashmap.put(key, new ArrayList<>());
            }
            hashmap.get(key).add(s);
        }

        for(Map.Entry<String, List<String>> entry : hashmap.entrySet())
        {
            result.add(entry.getValue());
        }
        return result;
    }
}
