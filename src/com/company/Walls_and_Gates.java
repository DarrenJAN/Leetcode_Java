package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class Walls_and_Gates {
    int[][] dir = new int[][] {{0,1}, {1,0}, {0,-1}, {-1, 0}};

    public void wallsAndGates(int[][] rooms) {
        int row = rooms.length;
        int col = rooms[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0 ;i< row;i++)
        {
            for(int j = 0; j< col;j++)
            {
                if(rooms[i][j] == 0)
                    queue.add(new int[]{i,j});
            }
        }

        while(!queue.isEmpty())
        {
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];
            for(int i = 0;i< 4;i++) {
                int new_x = x + dir[i][0];
                int new_y = y + dir[i][1];

                if (new_x < 0 || new_y < 0 || new_x >= row || new_y >= col)
                {
                    continue;
                }

                if(rooms[new_x][new_y] != Integer.MAX_VALUE || rooms[new_x][new_y] == -1)
                    continue;

                rooms[new_x][new_y] = rooms[x][y] +1;
                queue.add(new int[] { new_x, new_y});
            }
        }
    }
}
