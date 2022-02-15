package com.company;

public class Redundant_Connection {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length +1;
        UnionFindSet unionFindSet = new UnionFindSet(n);

        for(int i = 0;i<edges.length;i++)
        {
            int src = edges[i][0];
            int des = edges[i][1];

            if( !unionFindSet.Union(src,des))
            {
                return new int[] { src, des };
            }

        }
        throw new AssertionError();
    }

    class UnionFindSet{
        int[] parent;
        int[] rank;

        public  UnionFindSet(int n)
        {
            parent = new int[n];
            rank = new int[n];

            for(int i = 0 ;i<n;i++)
            {
                parent[i] = i;
                rank[i] =1;
            }
        }

        public int Find(int x)
        {
            if( x != parent[x])
                parent[x] = Find(parent[x]);

            return parent[x];
        }

        public boolean Union(int x , int y)
        {
            int parentx = Find(x);
            int parenty = Find(y);

            if(parentx == parenty)
                return false;

            if(rank[parentx] > rank[parenty])
            {
                parent[parenty] = parentx;
            }else if(rank[parenty] > rank[parentx])
            {
                parent[parentx] = parenty;
            }else
            {
                parent[parentx] = parenty;
                rank[parenty]++;
            }

            return true;
        }
    }
}
