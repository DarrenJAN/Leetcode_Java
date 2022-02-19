package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class Set_Matrix_Zeroes {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        if(row == 0) return;;
        int col = matrix[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int[] row_clean = new int[row];
        int[] col_clean = new int[col];

        for(int i = 0 ;i<row;i++)
        {
            for(int j = 0;j< col;j++)
            {
                if(matrix[i][j] == 0)
                    queue.add(new int[]{i,j});
            }
        }

        while(!queue.isEmpty())
        {
            int[] pos  = queue.poll();
            int x = pos[0];
            int y = pos[1];

            if(row_clean[x] == 0)
            {
                for(int i = 0;i<col;i++)
                    matrix[x][i] = 0;
                row_clean[x] =1;
            }

            if(col_clean[y] == 0)
            {
                for(int i = 0;i<row;i++)
                    matrix[i][y] = 0;

                col_clean[y] =1;
            }
        }
    }

}
