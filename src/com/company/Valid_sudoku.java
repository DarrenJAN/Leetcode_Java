package com.company;

public class Valid_sudoku {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] box = new int[9][9];

        for(int i = 0;i < 9;i++)
        {
            for(int j = 0; j< 9;j++)
            {
                char cur = board[i][j];
                if(cur == '.')
                    continue;
                else
                {
                    int num = cur - '1';
                    if(row[i][num] ==  1)
                        return false;
                    else
                        row[i][num] = 1;

                    if(col[j][num] == 1)
                        return false;
                    else
                        col[j][num] = 1;

                    int box_index = (i /3) *3 + j/3;
                    if(box[box_index][num] == 1)
                        return false;
                    else
                        box[box_index][num] = 1;
                }
            }
        }

        return true;

    }

}
