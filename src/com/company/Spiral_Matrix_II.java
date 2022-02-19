package com.company;

public class Spiral_Matrix_II {
    public int[][] generateMatrix(int n) {
        int num = n*n;

        int[][] result = new int[n][n];

        int top_row = 0;
        int bot_row = n-1;
        int left_col = 0;
        int right_col = n-1;

        int k =1;
        while(k <= num)
        {
            for(int i = left_col; i<=right_col;i++)
            {
                result[top_row][i] = k;
                k++;
            }
            top_row++;

            if(k > num)
                break;

            for(int i = top_row; i<=bot_row;i++)
            {
                result[i][right_col] = k;
                k++;
            }
            right_col--;

            if(k > num)
                break;
            for(int i = right_col;i>= left_col;i--)
            {
                result[bot_row][i] = k;
                k++;
            }
            bot_row--;

            if(k > num)
                break;
            for(int i = bot_row;i>= top_row;i--)
            {
                result[i][left_col] = k;
                k++;
            }
            left_col++;
        }
        return result;

    }

}
