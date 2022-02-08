package com.company;

import java.util.*;

public class Find_All_Anagrams_in_a_String {
    HashSet<String> hashSet = new HashSet<>();

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();
        int p_len = p.length();

        boolean[] visited = new boolean[p.length()];
        backtrack(p,  "", visited);

        for(int i = 0;i< s.length()-p_len+1;i++)
        {
            String cur_string = s.substring(i, i+p_len);
            if(hashSet.contains(cur_string))
                result.add(i);
        }

        return result;

    }

    public void backtrack(String str, String path, boolean[] visited)
    {
        if(path.length() == str.length())
        {
            hashSet.add(new String(path));
            System.out.println(path);
            return;
        }

        for(int i = 0; i< str.length();i++)
        {
            if( !visited[i])
            {
                visited[i] =true;
                path += str.charAt(i);

                backtrack(str, path, visited);

                path = path.substring(0, path.length()-1);
                visited[i] =false;
            }
        }
    }



    //上面的超时了
    HashMap<Character, Integer> p_hashmap = new HashMap<>();
    HashMap<Character, Integer> s_hashmap = new HashMap<>();

    public List<Integer> findAnagrams_2(String s, String p) {

        List<Integer> result = new ArrayList<>();
        int p_len = p.length();
        int s_len = s.length();

        for(int i =0; i< p_len;i++)
            p_hashmap.put(p.charAt(i), p_hashmap.getOrDefault(p.charAt(i), 0) +1);

        for(int i = 0;i< s_len;i++)
        {
            char c = s.charAt(i);
            s_hashmap.put(c, s_hashmap.getOrDefault(c, 0)+1);

            if( i>= p_len)
            {
                char c_del = s.charAt( i - p_len);
                if(s_hashmap.get(c_del) == 1)
                    s_hashmap.remove(c_del);
                else
                    s_hashmap.put(c_del, s_hashmap.get(c_del)-1);
            }

           if(s_hashmap.equals(p_hashmap))
               result.add(i-p_len+1);
        }

        return result;
    }


}
