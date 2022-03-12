package com.company;

import java.util.HashMap;
import java.util.List;

public class Evaluate_Division {
    HashMap<String, Integer> hashMap = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int size =equations.size();
        UnionFind unionFind = new UnionFind(2*size);
        int index = 0;
        for(int  i=0;i<equations.size();i++) {
            String v1 = equations.get(i).get(0);
            String v2 = equations.get(i).get(1);
            double q = values[i];
            if (!hashMap.containsKey(v1)) {
                hashMap.put(v1, index++);
            }
            if (!hashMap.containsKey(v2))
                hashMap.put(v2, index++);

            int index1 = hashMap.get(v1);
            int index2 = hashMap.get(v2);
            unionFind.union(index1, index2, q);
        }

            double[] ans = new double[queries.size()];
            for (int i = 0; i < queries.size(); i++) {
                String v1 = queries.get(i).get(0);
                String v2 = queries.get(i).get(1);
                int index1 = hashMap.get(v1);
                int index2 = hashMap.get(v2);
                if (!hashMap.containsKey(v1) || !hashMap.containsKey(v2))
                    ans[i] = -1.0;
                else if (v1.equals(v2))
                    ans[i] = 1.0;
                else {
                    ans[i] = unionFind.get_quo(index1, index2);
                }
            }
            return ans;
        }



    class UnionFind
    {
        int[] parent;
        int[] rank;
        double[] weight;
        int compoent;

        UnionFind(int size)
        {
            parent= new int[size];
            rank  = new int[size];
            weight = new double[size];

            compoent  = size;
            for(int i = 0;i<size;i++)
            {
                parent[i] = i;
                rank[i] =1;
                weight[i] = 1.0;
            }
        }

        int find(int x)
        {
            if(x != parent[x])
            {
                int origp = parent[x];
                parent[x] = find(parent[x]);
                weight[x] *= weight[origp];
            }

            return parent[x];
        }

        boolean union(int x, int y, double value)
        {
            int px = find(x);
            int py = find(y);
            if(px  == py)
                return false;

            if(rank[px] > rank[py]) {
                parent[py] = px;
                weight[py] = weight[y] * value / weight[x];
            }
            else if(rank[py] > rank[px])
            {
                parent[px] = py;

                weight[px] = weight[x] / value / weight[y];
            }
            else
            {
                parent[px] = py;
                rank[py] ++;
                weight[px] = weight[x] / value / weight[y];
            }
            compoent--;
            return  true;
        }

        int getCompoent(){
            return compoent;
        }

        boolean isConnected(int x , int y)
        {
            return find(x) == find(y);
        }

        double get_quo(int  x , int y)
        {
            if(isConnected(x, y))
            {
                return weight[x] / weight[y];
            }
            else
                return -1.0;
        }

    }
}
