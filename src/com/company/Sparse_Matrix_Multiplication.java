package com.company;

import java.util.ArrayList;

public class Sparse_Matrix_Multiplication {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int row1 = mat1.length;
        int col1 = mat1[0].length;

        int row2 = mat2.length;
        int col2 = mat2[0].length;

        int[][] result = new int[row1][col2];
        for(int i = 0; i< row1;i++)
        {
            int r1 = i;
            int[] row = mat1[i];
            for(int j = 0; j< col2 ; j++)
            {
                int cur = product(row, j, mat2);
                result[i][j] = cur;
            }
        }
        return result;
    }

    public int product(int[] rows, int col, int[][] mat2)
    {
        int row = mat2.length;
        int result = 0;
        for(int i = 0;i< row;i++)
        {
            result += rows[i]*mat2[i][col];
        }
        return result;
    }


    //compress Matrix
    public int[][] multiply_2(int[][] mat1, int[][] mat2) {
        int row1 = mat1.length;
        int col1 = mat1.length;
        int row2 = col1;
        int col2 = mat2[0].length;

        ArrayList<ArrayList<Pair>> A = compress(mat1);
        ArrayList<ArrayList<Pair>> B = compress(mat2);

        int[][] result = new int[row1][col2];
        for(int i =0 ;i< row1;i++)
        {
            for(Pair pair: A.get(i))
            {
                int element1 = pair.x;
                int col = pair.y;
                for(Pair pair1: B.get(col))
                {
                    int element2 = pair1.x;
                    int co = pair1.y;
                    result[i][co] += element1 * element2;
                }
            }
        }
        return result;
    }

    public ArrayList<ArrayList<Pair>> compress(int[][] mat1)
    {
        int row = mat1.length;
        int col = mat1.length;
        ArrayList<ArrayList<Pair>> result = new ArrayList<>();

        for(int i = 0;i< row;i++)
        {
            result.add(new ArrayList<>());
            for (int j = 0;j< col;j ++)
            {
                if(mat1[i][j] != 0)
                {
                    result.get(i).add(new Pair(mat1[i][j], j));
                }
            }
        }
        return result;
    }



    class Pair{
        int x;
        int y;

        Pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
}
