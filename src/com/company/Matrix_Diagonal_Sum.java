package com.company;

public class Matrix_Diagonal_Sum {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;

        for(int i = 0; i< n;i++)
        {
            sum+= mat[i][i];
        }

        for(int i = n -1;i>=0;i--)
        {
            sum+= mat[n-1 -i][i];
        }

        if(n % 2 != 0)
            sum = sum - mat[n/2][n/2];

        return sum;
    }

}
