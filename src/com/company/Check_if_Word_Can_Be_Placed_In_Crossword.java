package com.company;

public class Check_if_Word_Can_Be_Placed_In_Crossword {
    int[][]dir = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean placeWordInCrossword(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;

        for(int i = 0;i<row;i++)
        {
            for(int j = 0;j< col ;j++)
            {
                if(board[i][j] != '#')
                {
                    if( (j==0 || board[i][j-1] == '#') && dfs(board, word, 0, i,j, 0))
                        return true;
                    if((i==0 || board[i-1][j] == '#') && dfs(board, word, 0, i,j, 1))
                        return true;
                    if((j==col-1 || board[i][j+1] == '#') && dfs(board, word, 0, i,j, 2))
                        return true;
                    if((i==row-1 || board[i+1][j] == '#') && dfs(board, word, 0, i,j, 3))
                        return true;
                }

            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int start, int x, int y, int d)
    {
        int row = board.length;
        int col = board[0].length;
        int new_x = x + dir[d][0];
        int new_y = y + dir[d][1];
        //System.out.println(start);
        if(start >= word.length())
        {
            //System.out.println(new_x +" "+ new_y + " " +d);
            return !isRange(x, y, row, col) || board[x][y] == '#';
        }

        if(!isRange(x, y, row, col))
        {
            return false;
        }

        if(board[x][y] != ' ' && board[x][y] != word.charAt(start))
        {
            return false;
        }

        return (dfs(board, word, start+1, new_x, new_y, d));

    }

    boolean isRange(int new_x, int new_y, int row, int col)
    {
        if(new_x < 0 ||  new_y < 0 || new_x >= row || new_y >= col)
            return false;

        else
            return true;
    }

}
