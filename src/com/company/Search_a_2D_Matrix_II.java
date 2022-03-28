package com.company;

public class Search_a_2D_Matrix_II {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        for(int i = 0;i< row;i++)
        {
            if(target > matrix[i][col-1])
                continue;
            else
            {
                if(binarySeach(matrix[i], target))
                    return true;
            }
        }
        return false;
    }

    public boolean binarySeach(int[] cur_row, int target)
    {
        int l = 0;
        int r = cur_row.length-1;
        while(l <= r)
        {
            int mid = (r- l)/2 + l;

            if(cur_row[mid] == target)
                return true;
            else if(cur_row[mid] < target)
            {
                l =mid +1;
            }else
            {
                r = mid -1;
            }
        }
        return false;
    }

    public boolean searchMatrix_2(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int search_row = row -1;
        int search_col =0;
        while(search_row >= 0 && search_col < col -1)
        {
            if(target == matrix[search_row][search_col])
                return true;
            else if(target < matrix[search_row][search_col])
            {
                search_row--;
            }else
            {
                search_col++;
            }
        }

        return false;
    }

}
