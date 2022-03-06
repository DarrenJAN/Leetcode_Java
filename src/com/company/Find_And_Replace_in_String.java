package com.company;

import java.util.HashMap;

public class Find_And_Replace_in_String {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        HashMap<Integer, Integer> hashMap= new HashMap<>();

        for(int i= 0;i<sources.length;i++)
        {
            String sub = s.substring(indices[i], indices[i] + sources[i].length());
            if(sub.equals(sources[i]))
                hashMap.put(indices[i], i);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i<s.length();i++)
        {
            if(hashMap.containsKey(i))
            {
                stringBuilder.append(targets[hashMap.get(i)]);
                i+=sources[hashMap.get(i)].length()-1;
            }else
                stringBuilder.append(s.charAt(i));
        }

        return stringBuilder.toString();
    }

}
