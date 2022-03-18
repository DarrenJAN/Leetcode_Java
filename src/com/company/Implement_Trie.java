package com.company;

public class Implement_Trie {

    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode('1');
        }

        public void insert(String word) {
            TrieNode it = root;
            char[] chars = word.toCharArray();
            for(char c : chars)
            {
                if(it.contain(c))
                {
                    it = it.get(c);
                }else
                {
                    it.add(c);
                    it = it.get(c);
                }
            }
            it.string = word;
            System.out.println(word);
        }

        public boolean search(String word) {
            TrieNode it = root;
            char[] chars = word.toCharArray();
            for(char c : chars)
            {
                if(it.contain(c)) {
                    it = it.get(c);
                }else
                    return false;
            }

            if(it.string == null)
                return false;
            else
                return true;
        }

        public boolean startsWith(String prefix) {
            TrieNode it = root;
            char[] chars = prefix.toCharArray();
            for(char c : chars)
            {
                if(it.contain(c)) {
                    it = it.get(c);
                }else
                    return false;
            }

            return true;
        }
    }

    class TrieNode
    {
        char c;
        String string;
        TrieNode[] trieNodes;

        TrieNode(char c)
        {
            this.c = c ;
            trieNodes = new TrieNode[26];
        }

        boolean contain(char c)
        {
            return trieNodes[c -'a'] != null;
        }

        void add(char c)
        {
            if(!contain(c))
            {
                trieNodes[c - 'a'] = new TrieNode(c);
            }
        }

        TrieNode get(char c)
        {
            return trieNodes[c - 'a'];
        }

    }
}
