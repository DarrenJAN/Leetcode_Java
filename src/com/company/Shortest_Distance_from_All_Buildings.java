package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class Shortest_Distance_from_All_Buildings {
    int dirs[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int shortestDistance(int[][] grid) {
        int row = grid.length;
        if(row == 0)
            return 0;
        int col = grid[0].length;
        int totalhouse = 0;
        int result  = Integer.MAX_VALUE;

        for(int i = 0;i< row;i++)
        {
            for(int j = 0;j< col;j++)
            {
                if(grid[i][j] == 1)
                {
                    totalhouse++;
                }
            }
        }
        for(int i = 0;i< row;i++)
        {
            for(int j = 0;j< col;j++)
            {
                if(grid[i][j] == 0)
                {
                    int dis = bfs(grid, i, j ,totalhouse);
                    if(dis != Integer.MAX_VALUE){
                        result = Math.min(result, dis);
                    }
                }
            }
        }

        if(result == Integer.MAX_VALUE)
            return -1;
        else
            return result;

    }

    public int bfs(int[][]grid, int x, int y, int totalhouse)
    {
        int row = grid.length;
        if(row == 0)
            return 0;
        int col = grid[0].length;

        boolean[][] vis = new boolean[row][col];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        vis[x][y] = true;

        int dissum = 0;
        int steps = 0;
        int reachhouse = 0;
        while (!queue.isEmpty() &&  reachhouse != totalhouse)
        {
            int size = queue.size();
            for(int i = 0;i<size;i++)
            {
                int[] pos = queue.poll();
                int cur_x = pos[0];
                int cur_y = pos[1];

                if(grid[cur_x][cur_y] == 1)
                {
                    dissum += steps;
                    reachhouse++;
                    continue;
                }

                for(int j = 0;j<4;j++)
                {
                    int new_x = cur_x + dirs[j][0];
                    int new_y = cur_y + dirs[j][1];
                    if(new_x < 0 || new_y <0 || new_x>= row || new_y>= col)
                        continue;
                    if(grid[new_x][new_y] == 2 || vis[new_x][new_y] == true)
                        continue;

                    vis[new_x][new_y] = true;
                    queue.add(new int[] {new_x, new_y});

                }

            }
            steps++;
        }


        if(totalhouse != reachhouse)
        {
            for(int i = 0;i< row;i++)
            {
                for(int j = 0;j<col;j++)
                {
                    if(grid[i][j] == 0 && vis[i][j] == true)
                        grid[i][j] = 2;
                }
            }
            return Integer.MAX_VALUE;
        }

        return dissum;

    }
}
