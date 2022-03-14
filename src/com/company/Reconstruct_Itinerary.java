package com.company;

import java.util.*;

public class Reconstruct_Itinerary {
    HashMap<String, List<String>> hashMap = new HashMap<>();
    List<String> result = new ArrayList<>();

     public List<String> findItinerary(List<List<String>> tickets) {
        for(int i =0;i<tickets.size();i++)
        {
            String from = tickets.get(i).get(0);
            String to = tickets.get(i).get(1);
            if(!hashMap.containsKey(from))
            {
                hashMap.put(from, new ArrayList<>());
            }

            hashMap.get(from).add(to);
        }

        for(String str: hashMap.keySet())
        {
            Collections.sort(hashMap.get(str));
        }

//        Deque<String> deque = new ArrayDeque<>();
//        deque.add("JFK");
        dfs("JFK");
        return  result;
    }

    void dfs(String from)
    {
        if(hashMap.containsKey(from))
        {
            List<String> list = hashMap.get(from);
            int size =list.size();
            for(int i = 0;i<size;i++)
            {
                if(list.size() == 0)
                    break;
                String next = list.get(0);
                list.remove(next);
                dfs(next);
            }
        }
        result.add(0, from);
    }

}
