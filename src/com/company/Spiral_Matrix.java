package com.company;

import java.util.ArrayList;
import java.util.List;

public class Spiral_Matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int row = matrix.length;
        if (row == 0)
            return result;
        int col = matrix[0].length;

        int top_row = 0;
        int right_col = col - 1;
        int bot_row = row - 1;
        int left_col = 0;
        while (left_col <= right_col && top_row <= bot_row) {

            for (int i = left_col; i <= right_col; i++) {
                //System.out.print(matrix[top_row][i] + " ");
                result.add(matrix[top_row][i]);
            }
            top_row++;

            for (int i = top_row; i <= bot_row; i++) {
                result.add(matrix[i][right_col]);
            }
            right_col--;

            for (int i = right_col; i >= left_col; i--) {
                if(top_row > bot_row )
                    break;
                result.add(matrix[bot_row][i]);
            }
            bot_row--;

            for (int i = bot_row; i >= top_row; i--) {
                if(left_col > right_col)
                    break;
                result.add(matrix[i][left_col]);
            }
            left_col++;
        }

        return result;
    }
}
