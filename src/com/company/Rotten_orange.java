package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class Rotten_orange {

    public int orangesRotting(int[][] grid) {
        Queue<Pair> queue =new LinkedList<>();

        int row = grid.length;
        int col = grid[0].length;
        int freshorange = 0;
        int[][] dir = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        int min = -1;

        for(int i =0;i<row;i++)
        {
            for(int j =0;j<col;j++)
            {
                if(grid[i][j] == 2)
                    queue.add(new Pair(i,j));
                else if(grid[i][j] == 1)
                    freshorange++;
            }
        }

        if(freshorange ==0 )
            return 0;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            min ++;
            while(size >0 )
            {
                Pair pair = queue.poll();
                size--;
                int r = pair.i;
                int c = pair.j;
                for(int i =0; i<4;i++)
                {
                    int x = r+ dir[i][0];
                    int y = c + dir[i][1];
                    if(x>=0 && y>= 0 && x< row && y < col)
                    {
                        if(grid[x][y] == 1)
                        {
                            freshorange--;
                            grid[x][y] =2;
                            queue.add(new Pair(x, y));
                        }
                    }
                }
            }
        }
        return freshorange > 0? -1: min;
    }

    class Pair{
        int i, j;

        Pair(int i, int j)
        {
            this.i = i;
            this.j = j;
        }
    }
}
