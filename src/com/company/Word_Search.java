package com.company;

public class Word_Search {
    Boolean result = false;
    int[][] dir = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1 }};

    public boolean exist(char[][] board, String word) {
        if(board.length == 1 && board[0].length == 1)
            return board[0][0] == word.charAt(0) && word.length() == 1;

        for(int i= 0;i<board.length;i++)
        {
            for(int j = 0; j< board[0].length; j++)
                dfs(board, i, j, word, "", 0);
            if(result == true)
                return true;
        }
        return result;
    }

    void dfs(char[][] board, int row, int col, String word, String cur, int pos)
    {
        //System.out.println(cur);
        if(cur.equals(word))
        {
            result = true;
            return;
        }
        if(pos >= word.length() )
            return;

        if(word.charAt(pos) != board[row][col])
            return;

        cur += word.charAt(pos);
        pos ++;
        board[row][col] = '*';
        for(int i = 0; i< 4;i++)
        {
            int x = row + dir[i][0];
            int y = col + dir[i][1];

            if(x < 0 ||  y < 0 || x >= board.length || y >= board[0].length)
                continue;



            dfs(board, x,y, word, cur, pos);

        }
        board[row][col] = cur.charAt(cur.length()-1);
    }
}
