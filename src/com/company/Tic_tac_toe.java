package com.company;

public class Tic_tac_toe {
    public String tictactoe(int[][] moves) {
        int total_move = 9;
        int move = 0;
        int[][] board = new int[3][3];
        for(int i = 0;i< moves.length;i++)
        {
            int x  = moves[i][0];
            int y = moves[i][1];
            move +=1;
            if(i % 2 == 0)
            {
                board[x][y] = 1;
                if(move >= 5 && check(board, x, y, 1))
                {
                    return "A";
                }
            }else
            {
                board[x][y] = 2;
                if(move>=6 && check(board, x, y, 2))
                    return "B";
            }
        }

        if(move == 9)
            return "Draw";
        else
            return "Pending";
    }

    boolean check(int[][] board, int x, int y, int val)
    {
        //check row
        int row = 0;
        for(int i = 0;i< 3 ;i++)
        {
            if( board[x][i] != val)
                break;
            else
                row ++;
        }
        if(row == 3 )
            return true;

        //check col
        int col = 0;
        for(int i = 0;i< 3 ;i++)
        {
            //System.out.println("here");
            if( board[i][y] != val)
                break;
            else
                col ++;
        }
        if(col == 3 )
            return true;

        if( x == y )
        {
            int diag1 = 0;
            for(int i = 0;i< 3 ;i++)
            {
                if( board[i][i] != val)
                    break;
                else
                    diag1 ++;
            }
            if(diag1 == 3 )
                return true;
        }

        if( x ==  3- y-1 )
        {

            int diag2 = 0;
            for(int i = 0;i< 3 ;i++)
            {
                if( board[i][3-i-1] != val)
                    break;
                else
                    diag2 ++;
            }
            if(diag2 == 3 )
                return true;
        }

        return false;
    }

}
