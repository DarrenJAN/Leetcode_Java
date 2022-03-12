package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class TheEarliestMoment_WhenEveryoneBecomeFriends {
    public int earliestAcq(int[][] logs, int n) {
        UnionFind unionFind = new UnionFind(n);
        Arrays.sort(logs, (a, b) -> (a[0] - b[0]));
        for(int i =0;i< logs.length;i++)
        {
            unionFind.union(logs[i][1], logs[i][2]);
            if(unionFind.getCompoent() == 1)
                return logs[i][0];
        }
        return -1;
    }


    class UnionFind
    {
        int[] parent;
        int[] rank;
        int compoent;

        UnionFind(int size)
        {
            parent= new int[size];
            rank  = new int[size];
            compoent  = size;
            for(int i = 0;i<size;i++)
            {
                parent[i] = i;
                rank[i] =1;
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
            if(px  == py)
                return false;

            if(rank[px] > rank[py])
                parent[py] = px;
            else if(rank[py] > rank[px])
                parent[px] = py;
            else
            {
                parent[px] = py;
                rank[py] ++;
            }
            compoent--;
            return  true;
        }

        int getCompoent(){
            return compoent;
        }

    }
}
