package com.company;

import java.util.HashSet;

public class Number_of_Provinces {
    int col;
    int row;
    public int findCircleNum(int[][] isConnected) {
        int result = 0;
        this.row= isConnected.length;
        this.col = isConnected[0].length;

        for(int i = 0;i<row;i++)
        {
            for(int j = 0;j< col; j++)
            {
                if(isConnected[i][j] == 1)
                {
                    result++;
                    dfs(isConnected, i, j);
                }
            }
        }
        return result;
    }

    public void dfs(int[][] isConnected, int x, int y)
    {
        if(isConnected[x][y] == 0)
            return;

        if(isConnected[x][y] == 1)
        {
            isConnected[x][y] = 0;
            for(int i = 0; i< col;i++)
            {
                if(isConnected[x][i] == 1)
                {
                    isConnected[x][i] = 0;
                    dfs(isConnected, i,x);
                }
            }
        }
    }


    public int findCircleNum_2(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind unionFind = new UnionFind(n);
        for(int i =0;i<n;i++)
        {
            for(int j = 0;j< n;j++)
            {
                if(j != i)
                {
                    if(isConnected[i][j] == 1)
                    {
                        unionFind.union(i,j);
                    }
                }
            }
        }

        int count = 0;
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i =0;i<n;i++)
        {
            hashSet.add(unionFind.find(i));
        }
        return hashSet.size();
    }
    class UnionFind{
        int[] parent;
        int[] rank;

        UnionFind(int size)
        {
            parent = new int[size];
            rank = new int[size];
            for(int i = 0;i<size;i++)
            {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x){
            if( x  != parent[x])
            {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int p_x = find(x);
            int p_y = find(y);
            if (p_x == p_y)
                return false;

            if (rank[p_x] > rank[p_y])
                parent[p_y] = p_x;
            else if (rank[p_y] > rank[p_x])
                parent[p_x] = p_y;
            else {
                parent[p_y] = p_x;
                rank[p_x]++;
            }
            return true;

        }

        public boolean isConnect(int x, int y){
            return parent[x] == parent[y];
        }

    }
}
