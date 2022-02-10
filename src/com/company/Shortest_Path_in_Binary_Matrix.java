package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class Shortest_Path_in_Binary_Matrix {
    int[][] dir = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int row = grid.length;
        if(row == 0)
            return -1;
        int col = grid[0].length;

        if(grid[0][0] == 1)
            return -1;

        grid[0][0] = 1;
        Queue<int[] > queue = new LinkedList<>();
        queue.add(new int[] {0,0});

        while(! queue.isEmpty())
        {
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];
            if(x == row-1 && y == col-1)
                return grid[x][y];

            for(int i = 0;i< 8;i++)
            {
                int new_x = x+ dir[i][0];
                int new_y = y+ dir[i][1];

                if(new_x<0 || new_y < 0 || new_x >= row || new_y >= col)
                    continue;

                if(grid[new_x][new_y] == 0)
                {
                    //System.out.println(new_x+ " "+ new_y);
                    grid[new_x][new_y] = grid[x][y]+1;
                    queue.add(new int[] {new_x, new_y});
                }
            }

        }
        return -1;
    }
}
