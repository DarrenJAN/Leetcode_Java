package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class As_far_from_land_as_possible {
    int[][] dir= new int[][]{{0,1}, {0,-1}, {1, 0 } , {-1, 0}};

    public int maxDistance(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int result = -1;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1)
                    queue.add(new int[]{i, j});
            }
        }

        while (!queue.isEmpty())
        {
            int size = queue.size();
            result++;
            for(int i = 0;i< size;i++)
            {
                int[] pos = queue.poll();
                int x = pos[0];
                int y = pos[1];

                for(int j = 0;j< 4;j++)
                {
                    int n_x = x+ dir[j][0];
                    int n_y = y + dir[j][1];

                    if(n_x < 0 || n_y < 0 || n_x >= row || n_y >= col)
                    {
                        continue;
                    }

                    if(grid[n_x][n_y] == 1)
                        continue;

                    grid[n_x][n_y] = 1 ;
                    queue.add(new int[] { n_x, n_y});
                }
            }
        }
        if(result == 0)
            return -1;
        return result;
    }

}
