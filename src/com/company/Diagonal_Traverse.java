package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Diagonal_Traverse {
    public int[] findDiagonalOrder(int[][] mat) {

        int row = mat.length;;
        if( row == 0)
            return null;
        int col = mat[0].length;
        int[] result = new int[(row) * (col)];
        int k =0;

        for(int i = 0;i<col;i++)
        {
            int x =  0;
            int y =  i;
            List<Integer> cur;
            if( (x+y) % 2 == 0)
            {
                cur = getdiag(mat, x, y);
                Collections.reverse(cur);
            }
            else
            {
                cur = getdiag(mat,x,y);
            }

            for(int z = 0;z<cur.size();z++)
            {
                result[k++] = cur.get(z);
            }
        }

        for(int i = 1;i<row;i++)
        {
            int x = i;
            int y = col-1;
            List<Integer> cur;
            if( (x+y) % 2 == 0)
            {
                cur = getdiag(mat, x, y);
                Collections.reverse(cur);
            }
            else
            {
                cur = getdiag(mat,x,y);
            }

            for(int z = 0;z<cur.size();z++)
            {
                result[k++] = cur.get(z);
            }
        }

        return result;
    }

    List<Integer> getdiag (int[][] mat, int x, int y)
    {
        int row = mat.length;
        int col = mat[0].length;

        List<Integer> result = new ArrayList<>();
        if(x < 0 || y <0 || x>= row || y>= col)
            return result;

        result.add(mat[x][y]);

        while(x < row-1  && y > 0)
        {
            x++;
            y--;
            result.add(mat[x][y]);
        }


        return result;

    }
}
