package com.company;

public class Rotate_Image {
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        for(int i =0; i< row;i++)
        {
            for(int j = i+1;j<col ; j++)
            {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        //reverse each row
        for(int i =0;i<row;i++)
        {
            for(int j = 0;j<col/2;j++)
            {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][col - j-1];
                matrix[i][col - j-1] = tmp;
            }
        }
    }
}
