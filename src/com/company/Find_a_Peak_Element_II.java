package com.company;

public class Find_a_Peak_Element_II {
    int [] result = {-1,-1};
    int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};

    public int[] findPeakGrid(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        for(int i = 0;i< mat.length;i++)
        {
            for(int j = 0; j< mat[0].length;j++)
            {
                boolean flag = false;
                for(int z = 0; z < 4; z++)
                {
                    int x = i + dir[z][0];
                    int y = j + dir[z][1];

                    if(x < 0 || x >= row || y < 0 || y >= col)
                        continue;
                    else if( mat[x][y] > mat[i][j])
                    {
                        flag = true;
                        break;
                    }
                }
                if(!flag)
                {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }

            }
        }
        return result;
    }


    public int[] findPeakGrid_binary(int[][] mat) {
        int lcol = 0;
        int rcol = mat[0].length-1;

        int row = mat.length;
        int col = mat[0].length;

        while(lcol <= rcol)
        {
            int mid = (rcol - lcol) /2 +lcol;
            int max_row  =0;

            for(int i = 0;i< row;i++)
            {
                if(mat[max_row][mid] < mat[i][mid])
                    max_row = i;
            }

            if((mid == 0 || mat[max_row][mid] > mat[max_row][mid-1]) && (mid == col-1 || mat[max_row][mid] > mat[max_row][mid +1]))
            {
                return new int[]{max_row, mid};
            }else if(mid > 0 && mat[max_row][mid] < mat[max_row][mid-1])
            {
                rcol = mid -1;
            }else
            {
                lcol = mid +1;
            }

        }
        return new int[]{-1,-1};

    }
}
