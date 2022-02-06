package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class N_queens {
    List<List<String>> result = new ArrayList<>();
    HashSet<Integer> Col =new HashSet<>();
    HashSet<Integer> Diag1 =new HashSet<>();
    HashSet<Integer> Diag2 = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0 ;i < n;i++)
        {
            for(int j = 0; j< n;j++)
                board[i][j] = '.';
        }

        backtrack(board, n, 0,0);
        return result;
    }

    public void backtrack(char[][] board, int n, int row, int col)
    {
        if( row == n)
        {
            result.add(create_board(board,n));
            return;
        }

        for(int i = col;i<n;i++)
        {
            int diag1 =  row - i;
            int diag2 = row + i;
            if(Col.contains(i) || Diag1.contains(diag1) || Diag2.contains(diag2) )
                continue;

            board[row][i] = 'Q';
            Col.add(i);
            Diag1.add(diag1);
            Diag2.add(diag2);

            backtrack(board, n, row+1, 0);

            board[row][i] = '.';
            Col.remove(i);
            Diag1.remove(diag1);
            Diag2.remove(diag2);
        }
    }

    public List<String> create_board(char[][] board, int n)
    {
        List<String> r = new ArrayList<>();
        for(int i = 0;i < n; i++)
        {
            String str = "";
            for(int j = 0; j< n;j++)
            {
                str += board[i][j];
            }
            r.add(new String(str));
        }

        return r;
    }


}
