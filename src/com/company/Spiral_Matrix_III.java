package com.company;

public class Spiral_Matrix_III {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] dir = {{0,1}, {1,0}, {0, -1}, {-1, 0}};

        int total_nums = rows * cols;
        int[][] result = new int[total_nums][2];
        int k = 0;
        result[k][0] = rStart;
        result[k++][1] = cStart;
        int d = 0;
        int step_length = 0;


        while(k < total_nums)
        {
            if(d == 0 || d == 2)
                step_length++;

            for(int i = 0;i< step_length;i++)
            {
                rStart += dir[d][0];
                cStart += dir[d][1];
                if(rStart < 0 || cStart < 0 || rStart >= rows || cStart >= cols)
                    continue;
                result[k][0] = rStart;
                result[k++][1] = cStart;
            }

            d++;
            d = d % 4;

        }
        return result;
    }
}
