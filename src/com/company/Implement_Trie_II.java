package com.company;

public class Implement_Trie_II {
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
                it.addPreCount();
            }

            it.addWordCount();
            it.string = word;
            System.out.println(word);
        }

        public int countWordsEqualTo(String word) {
            char[] chars = word.toCharArray();
            TrieNode it = root;
            for(char c: chars)
            {
                if( ! it.contain(c))
                    return 0;
                else
                    it = it.get(c);
            }
            return it.getWord_Count();
        }

        public int countWordsStartingWith(String prefix) {
            char[] chars = prefix.toCharArray();
            TrieNode it = root;
            for(char c: chars)
            {
                if( ! it.contain(c))
                    return 0;
                else
                    it = it.get(c);
            }
            return it.getPrefix_Count();
        }

        public void erase(String word) {
            char[] chars = word.toCharArray();
            TrieNode it = root;
            for(char c: chars)
            {
                if( ! it.contain(c))
                    return;
                else
                    it = it.get(c);
                it.deletePreCount();
            }
            it.deleteWordCount();
        }


    }

    class TrieNode
    {
        char c;
        String string;

        int prefix_count;
        int word_count;
        TrieNode[] trieNodes;

        TrieNode(char c)
        {
            this.c = c ;
            this.word_count = 0;
            this.prefix_count = 0;
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



        void addPreCount()
        {
            this.prefix_count++;
        }

        void addWordCount()
        {
            this.word_count++;
        }

        void deletePreCount()
        {
            this.prefix_count--;
        }

        void deleteWordCount()
        {
            this.word_count--;
        }

        int getPrefix_Count()
        {
            return this.prefix_count;
        }

        int getWord_Count()
        {
            return this.word_count;
        }


    }
}
