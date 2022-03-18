package com.company;

class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode('1');
    }

    public void addWord(String word) {
        char[] chars = word.toCharArray();
        TrieNode it = root;
        for(char c : chars)
        {
            it.add(c);
            it = it.get(c);
        }
        it.path = word;
    }

    public boolean search(String word) {
        char[] chars = word.toCharArray();
        TrieNode it = root;

        return dfs(word, 0, it);
    }

    public boolean dfs(String word, int index, TrieNode it)
    {
        if(index == word.length())
        {
            return it.path != null;
        }
        char cur = word.charAt(index);
        if(cur == '.')
        {
            for(int j= 0;j<26;j++)
            {
                if(it.trieNodes[j] != null)
                {
                    TrieNode next = it.trieNodes[j];
                    if(dfs(word, index +1, next ))
                        return true;
                }
            }
            return false;
        }else
        {
            if(! it.contain(cur))
                return false;
            else
            {
                return dfs(word, index+1, it.get(cur));
            }
        }

    }


    class TrieNode
    {
        char c;
        String path;
        TrieNode[] trieNodes;

        TrieNode(char c)
        {
            this.c = c;
            trieNodes = new TrieNode[26];
        }

        boolean contain(char  c)
        {
            if(trieNodes[c - 'a'] == null)
                return false;
            else
                return true;
        }

        void add(char c)
        {
            if(! contain(c))
                trieNodes[c-'a'] = new TrieNode(c);
        }

        TrieNode get(char c)
        {
            return trieNodes[c-'a'];
        }





    }
}
