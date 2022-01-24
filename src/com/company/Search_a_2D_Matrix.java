package com.company;

public class Search_a_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if(row == 0)
            return false;
        int col = matrix[0].length;
        int which_row= 0;

        //First find which row should target be
        for(int i=0;i<row;i++)
        {

            if(target >= matrix[i][0])
            {
                which_row = i;
            }

        }

        for(int i =0;i<col;i++)
        {

            if(target == matrix[which_row][i])
                return true;
        }

        return false;
    }
}
