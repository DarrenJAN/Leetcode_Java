package com.company;

public class Sudoku_Solver {
    int n = 9;
    int[][] COL = new int[n][n+1];
    int[][] ROW = new int[n][n+1];
    int[][] SQUARE = new int[n][n+1];
    char[][] board;
    boolean solved = false;
    public void solveSudoku(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        // init rows, columns and boxes
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int d = Character.getNumericValue(num);
                    placeNumber(i, j, d);
                }
            }
        }
        backtrack(0, 0);
//        for(int i = 0;i < row;i++)
//        {
//            for(int j = 0;j<col;j++)
//            {
//                if(board[i][j] != '.')
//                {
//                    int cur_num = board[i][j] - '0';
//                    COL[i][cur_num] ++;
//                    ROW[j][cur_num] ++;
//
//                    int block = (i / 3) * 3  + j /3;
//                    SQUARE[block][cur_num] ++;
//                }
//            }
//        }
//        this.board = board;
//
//        backtrack(0,0);

    }

    public void backtrack(int row, int col)
    {
        if(board[row][col] == '.')
        {
            for(int i = 1; i< 10 ;i++)
            {
                if(couldplaceNumber(row, col, i))
                {
                    placeNumber(row, col,  i);
                    placeNextNumer(row, col);
                    if( !solved)
                        removeNumber(row,col, i);
                }
            }
        }else
        {
            placeNextNumer(row, col);
        }
    }

    public void placeNextNumer(int row, int col)
    {
        if(row == n -1  && col == n-1)
        {
            solved = true;
            return;
        }

        if(col == n -1)
        {
            backtrack(row+1, 0);
        }else
            backtrack(row, col +1);
    }

    public void placeNumber(int row, int col, int d)
    {
        int block = (row /3 ) * 3 + col /3;

        ROW[row][d]++;
        COL[col][d]++;
        SQUARE[block][d] ++;
        board[row][col] = (char)(d + '0');
    }

    public void removeNumber(int row, int col, int d)
    {
        int block = (row /3 ) * 3 + col /3;

        ROW[row][d]--;
        COL[col][d]--;
        SQUARE[block][d] --;
        board[row][col] = '.';
    }

    public boolean couldplaceNumber(int row, int col, int d)
    {
        int block = (row /3 ) * 3 + col /3;

        if(ROW[row][d] == 1  ||  COL[col][d] == 1 || SQUARE[block][d] == 1)
            return false;
        else
            return true;
    }


}
