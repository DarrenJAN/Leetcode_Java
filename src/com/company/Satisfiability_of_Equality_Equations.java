package com.company;

public class Satisfiability_of_Equality_Equations {
    public boolean equationsPossible(String[] equations) {
        DSU dsu = new DSU(26);
        int length = equations.length;

        for(int i =0;i< length;i++)
        {
            String cur = equations[i];
            if(cur.charAt(1) == '=')
            {
                int a = cur.charAt(0) -'a';
                int b = cur.charAt(3) - 'a';
                dsu.union(a, b);
            }
        }

        for(int i =0;i< length;i++)
        {
            String cur = equations[i];
            if(cur.charAt(1) == '!')
            {
                int a = cur.charAt(0) -'a';
                int b = cur.charAt(3) - 'a';
                if(dsu.find(a) == dsu.find(b))
                    return false;
            }
        }
        return true;
    }

    class DSU{
        int[] parent;
        int[] rank;

        DSU(int n )
        {
            parent = new int[n];
            rank = new int[n];

            for(int i = 0;i< n;i++)
            {
                parent[i] = i;
                rank[i] = 1;
            }

        }

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }

        public boolean union(int x, int y)
        {
            int p_x = find(x);
            int p_y = find(y);

            if(p_x == p_y)
                return false;

            if(rank[p_x] > rank[p_y])
            {
                parent[p_y] = p_x;
            }else if(rank[p_y] > rank[p_x])
            {
                parent[p_x] = p_y;
            }else
            {
                parent[p_x] = p_y;
                rank[p_y]++;
            }
            return true;
        }
    }
}
