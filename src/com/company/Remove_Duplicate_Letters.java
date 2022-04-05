package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Remove_Duplicate_Letters {
    public String removeDuplicateLetters(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        HashSet<Character> seen = new HashSet<>();

        for(int i = 0;i< s.length();i++)
        {
            char c = s.charAt(i);
            hashMap.put(c, i);
        }

        for(int i =0 ; i < s.length();i++)
        {
            char c = s.charAt(i);
            if(! seen.contains(c))
            {
                while(!stack.isEmpty() && c < stack.peek()  && hashMap.get(stack.peek()) > i)
                {
                    seen.remove(stack.pop());
                }
                stack.add(c);
                seen.add(c);
            }
        }

        for(Character c: stack)
        {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
