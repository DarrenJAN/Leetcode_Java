package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Number_of_Matching_Subsequences {
    public int numMatchingSubseq(String S, String[] words) {
        HashSet<String> isSub = new HashSet<>();
        HashSet<String> notSub = new HashSet<>();
        int count = 0;
        for(String word: words)
        {
            if(isSub.contains(word))
            {
                count++;
                continue;
            }
            if(notSub.contains(word))
            {
                continue;
            }

            if(isSubhelper(S, word))
            {
                isSub.add(word);
                count++;
            }else
            {
                notSub.add(word);
            }
        }
        return  count;
    }

    public boolean isSubhelper(String s, String word)
    {
        if(word.length()==0)
            return true;

        int j =0;
        for(int i = 0;i<s.length();i++)
        {
            if(s.charAt(i) == word.charAt(j))
            {
                j++;
                if(j == word.length())
                    return true;
            }
        }
        return false;
    }

    class Node {
        String word;
        int index;

        public Node(String w, int i) {
            word = w;
            index = i;
        }
    }

    public int numMatchingSubseq_2(String S, String[] words) {
        int ans = 0;
        ArrayList<Node>[] head= new ArrayList[26];

        for(int i =0;i< 26;i++)
            head[i] = new ArrayList<>();

        for(String word: words)
        {
            head[word.charAt(0) - 'a'].add(new Node(word, 0));
        }

        for(int i =0;i< S.length();i++)
        {
            ArrayList<Node> old = head[S.charAt(i)-'a'];
            head[S.charAt(i)-'a'] = new ArrayList<>();

            for(Node node: old)
            {
                node.index ++;
                if(node.index == node.word.length())
                {
                    ans++;
                }else
                {
                    head[node.word.charAt(node.index) -'a'].add(node);
                }
            }
            old.clear();
        }

        return  ans;
    }


}
