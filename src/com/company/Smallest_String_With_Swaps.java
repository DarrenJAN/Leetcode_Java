package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Smallest_String_With_Swaps {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        MyDSU myDSU = new MyDSU(s.length());
        HashMap<Integer, List<Character>> map = new HashMap<>();

        for(List<Integer> edge: pairs)
        {
            int src = edge.get(0);
            int des = edge.get(1);
            myDSU.union(src, des);
        }

        for(int i =0 ;i<s.length();i++)
        {
            int parent = myDSU.find(i);
            if(! map.containsKey(parent))
                map.put(parent, new ArrayList<>());
            map.get(parent).add(s.charAt(i));
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(List<Character> characters: map.values())
        {
            Collections.sort(characters, Collections.reverseOrder());

        }

        for(int i = 0; i<s.length();i++)
        {
            List<Character> characters = map.get(myDSU.find(i));
            char currentMin = characters.remove(characters.size()-1);
            stringBuilder.append(currentMin);
        }

        return stringBuilder.toString();
    }



    class MyDSU{
        int[] parent;
        int[] rank;
        int component;

        public MyDSU(int size)
        {
            parent = new int[size];
            rank = new int[size];

            for(int i = 0 ;i<size;i++)
            {
                parent[i] = i;
                rank[i] = 0;
            }
            component = size;

        }

        public int find(int  x)
        {
            if( x  == parent[x] )
                return x;
            else
                return parent[x] = find(parent[x]);
        }

        public boolean union(int x, int y )
        {
            int parentx = find(x);
            int parenty = find(y);

            if(parentx == parenty)
                return false;

            if(rank[parentx] > rank[parenty])
            {
                parent[parenty] = parentx;
            }else if(rank[parenty] > rank[parentx])
            {
                parent[parentx] = parenty;
            }else
            {
                parent[parenty] = parentx;
                rank[parentx] ++;
            }

            component --;
            return true;
        }

        public int getComponent(){
            return  component;
        }
    }
}
