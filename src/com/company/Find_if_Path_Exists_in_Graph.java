package com.company;

public class Find_if_Path_Exists_in_Graph {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        UnionFind unionFind = new UnionFind(n);
        for(int i =0;i< edges.length;i++)
        {
            unionFind.union(edges[i][0], edges[i][1]);
        }

        return unionFind.isConnected(source, destination);
    }

    class UnionFind{
        int[]parent;
        int[] rank;

        UnionFind(int size)
        {
            parent = new int[size];
            rank = new int[size];

            for(int i = 0;i< size;i++)
            {
                parent[i] = i;
                rank[i]= 1;
            }
        }

        int find(int x)
        {
            if(x != parent[x])
                parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int x, int y)
        {
            int px = find(x);
            int py = find(y);
            if(px == py )
                return false;

            if(rank[px] > rank[py ])
                parent[py] = px;
            else if(rank[py] > rank[px])
                parent[px] = py;
            else
            {
                parent[px] = py;
                rank[py] ++;
            }
            return true;
        }

        boolean isConnected(int x, int y)
        {
            return find(x) == find(y);
        }
    }
}
