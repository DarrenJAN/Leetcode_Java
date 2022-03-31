package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Reorganize_String {
    HashMap<Character, Integer> hashMap = new HashMap<>();
    public String reorganizeString(String s) {
        for(int i = 0;i< s.length();i++)
        {
            char c = s.charAt(i);
            hashMap.put(c, hashMap.getOrDefault(c, 0)+1);
        }
        PriorityQueue<Character> priorityQueue = new PriorityQueue<>( (a,b) -> (hashMap.get(b) - hashMap.get(a)));
        for(Character c: hashMap.keySet())
            priorityQueue.add(c);

        StringBuilder stringBuilder = new StringBuilder();
        while(priorityQueue.size() > 1)
        {
            char first = priorityQueue.remove();
            char second = priorityQueue.remove();

            hashMap.put(first, hashMap.get(first)-1);
            hashMap.put(second, hashMap.get(second)-1);

            if(hashMap.get(first) > 0)
                priorityQueue.add(first);
            if(hashMap.get(second) > 0)
                priorityQueue.add(second);

            stringBuilder.append(first);
            stringBuilder.append(second);
        }

        if(! priorityQueue.isEmpty())
        {
            char last = priorityQueue.remove();
            if(hashMap.get(last) > 1)
                return "";

            else
                stringBuilder.append(last);
        }

        return stringBuilder.toString();
    }
}
