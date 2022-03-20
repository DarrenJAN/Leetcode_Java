package com.company;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString_II {
    public String removeDuplicates(String s, int k) {

        char[] chars = s.toCharArray();
        Stack<Pair> stack = new Stack<>();

        for(char c : chars)
        {
            if(stack.isEmpty())
            {
                stack.push(new Pair(c));
            }else
            {
                Pair last = stack.peek();
                if(last.c == c)
                {
                    if(last.fre == k-1)
                        stack.pop();
                    else
                        last.add();
                }else
                {
                    stack.push(new Pair(c));
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while( ! stack.isEmpty())
        {
            Pair p = stack.pop();
            for(int i =0;i< p.fre;i++)
            {
                stringBuilder.append(p.c);
            }
        }

        stringBuilder.reverse();
        return stringBuilder.toString();
    }

    class Pair
    {
        char c;
        int fre;
        Pair(char c)
        {
            this.c = c;
            this.fre = 1;
        }

        Pair(char c, int fre)
        {
            this.c = c;
            this.fre = fre;
        }


        void add()
        {
            this.fre ++;
        }

    }
}
