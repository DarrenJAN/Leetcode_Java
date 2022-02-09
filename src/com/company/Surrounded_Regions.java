package com.company;

public class Surrounded_Regions {
    int row;
    int col;
    int[][] dir = new int[][] {{0,1}, {0, -1}, {1, 0}, {-1,0}};

    public void solve(char[][] board) {
        this.row = board.length;
        this.col = board[0].length;

        for(int i =0 ; i< row; i++)
        {
            if(board[i][0] == 'O')
                dfs(board, i, 0);

            if(board[i][col-1] == 'O')
                dfs(board, i , col-1);
        }

        for(int i= 1; i< col;i++)
        {
            if(board[0][i] == 'O' )
                dfs(board, 0, i);

            if(board[row-1][i] == 'O')
                dfs(board, row-1, i);
        }


        for(int i = 0 ;i<row;i++)
        {
            for(int j = 0;j< col;j++)
            {
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == 'E')
                    board[i][j] = 'O';
            }
        }
    }

    public void dfs(char[][] board, int x, int y) {
        if (x < 0 || y < 0 || x >= row || y >= col)
            return;

        if (board[x][y] == 'O')
        {
            board[x][y] = 'E';
            for(int i = 0;i<4;i++)
            {
                int new_x = x + dir[i][0];
                int new_y = y + dir[i][1];

                dfs(board, new_x, new_y);
            }
        }
    }
}
