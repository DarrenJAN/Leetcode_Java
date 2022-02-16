package com.company;

public class Valid_Tic_Tac_Toe_State {
    String[] boardd;
    int num_x = 0;
    int num_o = 0;
    int n = 3;
    boolean isWinO = false;
    boolean isWinX = false;
    public boolean validTicTacToe(String[] board) {

        for(int i = 0;i < 3;i++)
        {
            String cur_ = board[i];
            for(int j = 0;j< 3;j++)
            {
                if(cur_.charAt(j) == 'O')
                    num_o++;
                else if(cur_.charAt(j) == 'X')
                    num_x++;
            }
        }
        if(num_o > num_x || Math.abs(num_o - num_x) >= 2 )
        {
            //System.out.println("hi" + num_o + " "+ num_x);
            return false;
        }

        isWinX = CheckWin(board, 'X');
        isWinO = CheckWin(board, 'O');
        if(isWinO && isWinX)
        {
            return false;
        }
        if (isWinX && num_x != num_o+1) { // x can win if count(x) == count(o)+1
            return false;
        }

        if (isWinO && num_x != num_o) { // o can win if count(x) == count(o)
            return false;
        }

        return true;
    }

    public  boolean CheckWin(String[] board, char ch)
    {
        for(int i = 0; i< 3; i++)
        {
            int row= 0;
            int col = 0;
            for(int j= 0;j< 3;j++)
            {
                if(board[i].charAt(j) == ch)
                {
                    row++;
                }
                if(board[j].charAt(i) == ch)
                {
                    col++;
                }
            }
            //System.out.println(row + " " + col);
            if(row == 3 || col == 3)
                return true;
        }

        int dig1 =0 ;
        int dig2 =0;
        for(int i = 0;i<3;i++)
        {
            if(board[i].charAt(i) == ch)
                dig1++;
            if(board[i].charAt(3-i-1) == ch)
                dig2++;
        }
        if(dig1 == 3 || dig2 == 3)
            return true;
        return false;
    }
}
