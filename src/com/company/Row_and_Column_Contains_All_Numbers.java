package com.company;

public class Row_and_Column_Contains_All_Numbers {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;

        int[][] row = new int[n][n+1];
        int[][] col = new int[n][n+1];

        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j< n;j++)
            {
                int cur_number = matrix[i][j];
                if(cur_number > n)
                    return false;

                if(col[j][cur_number]  == 1)
                    return false;
                else
                    col[j][cur_number] =1;

                if(row[i][cur_number]  == 1)
                    return false;
                else
                    row[i][cur_number] =1;

            }
        }

        return true;
    }
}
