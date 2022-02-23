package com.company;

import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partitioning {
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrack(0,s, new ArrayList<>());
        return result;
    }

    public void backtrack(int start, String s, List<String> path)
    {
        if(start >= s.length())
        {
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = start; i< s.length();i++)
        {
            String sub = s.substring(start, i+1);
            if(isPalidrome(sub))
            {
                path.add(sub);
                backtrack(i+1, s, path);
                path.remove(path.size()-1);
            }
        }
    }

    public boolean isPalidrome(String s)
    {
        int l = 0;
        int r = s.length()-1;
        while(l < r ) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }

}
