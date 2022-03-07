package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class Longest_Increasing_Path_in_a_Matrix {
    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dir = new int[][] { {0,1}, {0,-1}, {1,0}, {-1,0}};

        int[][] indegree = new int[row][col];
        int  length =0;
        Queue<int[]> queue = new LinkedList<>();

        for(int i =0;i< row;i++)
        {
            for(int j = 0;j< col ;j++)
            {
                for(int z =0;z<4;z++)
                {
                    int x = i + dir[z][0];
                    int y = j + dir[z][1];
                    if(x< 0 || y< 0 || x>= row || y >= col)
                        continue;

                    if(matrix[x][y] < matrix[i][j])
                        indegree[i][j] +=1;
                }
                if(indegree[i][j] == 0)
                    queue.add(new int[] {i,j}) ;
            }
        }
        while(!queue.isEmpty())
        {
            length++;
            int size = queue.size();
            for(int i =0;i<size;i++)
            {
                int[] pos = queue.poll();
                int x = pos[0];
                int y = pos[1];
                for(int j = 0;j<4;j++)
                {
                    int new_x = x + dir[j][0];
                    int new_y = y + dir[j][1];
                    if(new_x< 0 || new_y< 0 || new_x>= row || new_y >= col)
                        continue;

                    if(matrix[new_x][new_y] > matrix[x][y])
                    {
                        indegree[new_x][new_y]--;
                        if(indegree[new_x][new_y] == 0)
                        {
                            queue.add(new int[]{new_x, new_y});
                        }
                    }
                }
            }
        }
        return length;
    }
}
