package com.company;

public class Reshape_Matrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] result = new int[r][c];
        if(mat.length == 0 || r * c != mat.length * mat[0].length)
            return mat;

         int[] nums = new int[r*c];
         int z = 0;
         for(int i = 0; i<mat.length;i++)
         {
             for(int j = 0;j<mat[0].length;j++)
             {
                 nums[z] = mat[i][j];
                 z++;
             }
         }

         z = 0;
         for(int i =0;i<r;i++)
         {
             for(int j = 0 ;j< c;j++)
             {
                 result[i][j] = nums[z];
                 z++;
             }
         }

         return result;
    }

    public int[][] matrixReshape_2(int[][] mat, int r, int c) {
        if(mat.length == 0 || r* c != mat.length * mat[0].length)
            return mat;

        int[][] result = new int[r][c];

        int row = 0 ;
        int col =0;
        for(int i = 0;i < mat.length;i++)
        {
            for(int j =0; j < mat[0].length; j++)
            {
                if(col == c)
                {
                    col =0;
                    row++;
                }else
                    col++;

                result[row][col] =mat[i][j];
            }
        }
        return result;

    }
}
