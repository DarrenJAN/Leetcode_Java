package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTrie {
    BinaryTrieNode root;
    int max_different;

    BinaryTrie(List<String> binaries)
    {
         root = new BinaryTrieNode('2');
        max_different = 0;
        BinaryTrieNode cur = root;
         for(int i = 0;i< binaries.size();i++)
         {
             String cur_str = binaries.get(i);
             cur = root;
             //System.out.println(cur_str);

             for(char c: cur_str.toCharArray()) {

                 if(cur.get(c) == null)
                 {
                     //System.out.println("1 " + c);
                     BinaryTrieNode child = new BinaryTrieNode(c);
                     if(c == '0')
                         cur.left = child;
                     else
                         cur.right = child;
                     cur = child;
                 }else
                 {
                     //System.out.println("2 " + c);
                     cur = cur.get(c);
                 }
             }
         }

    }

    public int getDifferent( BinaryTrieNode root)
    {
        if(root == null)
            return 0;

        int left = getDifferent(root.left);
        int right = getDifferent(root.right);

        if(left > 0 && right > 0)
        {
            max_different = Math.max(max_different, left + right);
        }

        return Math.max(left, right)+ 1;
    }

    public int getMax_different()
    {
        getDifferent(root);
        return max_different;
    }



    class BinaryTrieNode
    {
        BinaryTrieNode left;
        BinaryTrieNode right;
        private char c;

        BinaryTrieNode(char c)
        {
            this.c = c ;
            left = null;
            right = null;
        }

        public  BinaryTrieNode get(char c)
        {
            if( c == '0')
                return left;
            else
                return right;
        }
    }



    public static void main(String[] args) {
        List<String> binaries = new ArrayList(Arrays.asList("1011100", "1011011"));

        BinaryTrie trie = new BinaryTrie(binaries);

        System.out.println(trie.getMax_different()); // gives 10 (1011100, 1001111) differ by 10.

        binaries = new ArrayList(Arrays.asList("101", "111","000"));

        trie = new BinaryTrie(binaries);

        System.out.println(trie.getMax_different()); // return 6 (101, 000)
    }
}
