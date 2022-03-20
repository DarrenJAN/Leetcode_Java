package com.company;

public class LongestSubstringOneRepeatingCharacter {
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int[] result = new int[queryIndices.length];
        StringBuilder stringBuilder = new StringBuilder(s);
        for(int i = 0;i< queryIndices.length;i++)
        {
            stringBuilder.setCharAt(queryIndices[i], queryCharacters.charAt(i));
            result[i] = compute(stringBuilder);
        }
        return result;
    }

    public int compute(StringBuilder stringBuilder)
    {
        int result= 1;
        int cur_len = 1;
        for(int i = 1;i<stringBuilder.length();i++)
        {
            if(stringBuilder.charAt(i) == stringBuilder.charAt(i-1))
            {
                cur_len++;
            }else
            {
                result = Math.max(result, cur_len);
                cur_len = 1;
            }
        }
        return result;
    }

    public int[] longestRepeating_2(String s, String queryCharacters, int[] queryIndices) {
        UnionFind unionFind = new UnionFind(s.length());
        int[] result = new int[queryIndices.length];
        int stringlength = s.length();
        StringBuilder stringBuilder = new StringBuilder(s);
        int cur_max = 1;

        for(int i = 1;i< stringBuilder.length();i++)
        {
            if(stringBuilder.charAt(i) == stringBuilder.charAt(i-1))
            {
                unionFind.union(i-1, i);
                cur_max = Math.max(cur_max, unionFind.getrank(i-1));
            }

        }

        for(int i = 0;i< queryIndices.length;i++)
        {
            char new_c = queryCharacters.charAt(i);
            int index = queryIndices[i];
            stringBuilder.setCharAt(index, new_c);
            if(index >= 0 && index< stringlength-1)
            {
                if(new_c == stringBuilder.charAt(index+1))
                {
                    unionFind.union(index, index+1);
                    cur_max = Math.max(cur_max, unionFind.getrank(index));
                }
            }

            if(index <= stringlength-1 && index > 0)
            {
                if(new_c == stringBuilder.charAt(index-1))
                {
                    unionFind.union(index-1, index);
                    cur_max = Math.max(cur_max, unionFind.getrank(index));
                }
            }
            result[i] = compute(stringBuilder);
        }
        return result;

    }

    class UnionFind
    {
        int[] parent;
        int[] rank;

        UnionFind(int s)
        {
            parent = new int[s];
            rank =  new int[s];
            for(int i = 0;i< s;i++)
            {
                parent[i] = i;
                rank[i] = 1;
            }

        }

        int find(int x)
        {
            if(parent[x] != x)
            {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        int getrank(int x)
        {
            return rank[find(x)];
        }

        boolean union(int x, int y)
        {
            int px = find(x);
            int py = find(y);
            parent[py] = px;
            rank[px] += rank[py];
            return true;
        }

        void set(int x)
        {
            rank[x] =1;
        }
    }

}
