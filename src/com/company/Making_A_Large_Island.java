package com.company;

import java.util.HashSet;

public class Making_A_Large_Island {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        UnionFindSet unionFindSet = new UnionFindSet(n * n);
        int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1, 0}};

        boolean haszero = false;
        for(int i=0;i<n;i++)
        {
            for(int j = 0;j<n;j++)
            {
                if(grid[i][j] == 0){
                    haszero = true;
                    continue;
                }else
                {
                    if(i+1 < n && grid[i+1][j] == 1)
                    {
                        int x = i * n + j;
                        int y = (i+1) * n + j;
                        unionFindSet.Union(x, y);
                    }
                    if(j+1 < n && grid[i][j+1] == 1)
                    {
                        int x = i*n + j;
                        int y = i*n + j+1;
                        unionFindSet.Union(x, y);
                    }
                }
            }
        }

        if(!haszero)
            return n*n;

        int max_island  = 0;
        for(int i = 0;i< n;i++)
        {
            for(int j =0;j< n ;j++)
            {
                HashSet<Integer> hashSet = new HashSet<>();
                int cur_island = 1;
                if(grid[i][j] == 0)
                {
                    for(int z = 0;z<4 ;z++)
                    {
                        int new_x = i + dir[z][0];
                        int new_y = j + dir[z][1];

                        if( new_x< 0 || new_y < 0 || new_x >= n || new_y >= n)
                            continue;

                        if(grid[new_x][new_y] ==1)
                        {
                            int key = new_x * n + new_y;
                            int parent = unionFindSet.find(key);
                            if( ! hashSet.contains(parent))
                            {
                                hashSet.add(parent);
                                cur_island += unionFindSet.getsize(parent);
                            }
                        }
                    }
                }
                max_island = Math.max(max_island, cur_island);
            }
        }

        return max_island;
    }


    class UnionFindSet{
        int[] parent;
        int[] rank;
        int[] clusterSize;

        UnionFindSet(int size)
        {
            parent = new int[size];
            rank = new int[size];
            clusterSize = new int[size];

            for(int i = 0;i< size;i++)
            {
                parent[i] = i;
                rank[i] = 1;
                clusterSize[i] = 1;
            }
        }

        public int find(int x)
        {
            if(parent[x] != x)
            {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean Union(int x, int y)
        {
            int parent_x = find(x);
            int parent_y = find(y);

            if(parent_x == parent_y)
                return false;

            if(rank[parent_y] > rank[parent_x])
            {
                parent[parent_x] = parent_y;
                clusterSize[parent_y] += clusterSize[parent_x];
            }else if(rank[parent_y] < rank[parent_x])
            {
                parent[parent_y] = parent_x;
                clusterSize[parent_x] += clusterSize[parent_y];
            } else
            {
                parent[parent_y]  = parent_x;
                rank[parent_x] ++;
                clusterSize[parent_x] += clusterSize[parent_y];
            }
            return true;
        }

        public int getsize(int x)
        {
            return clusterSize[x];
        }
    }
}
