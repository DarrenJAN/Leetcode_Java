package com.company;

import java.util.LinkedList;
import java.util.List;

public class Game_of_Life {
    int[][] dir = new int[][] {{-1,-1}, {-1,0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1,1}};
    List<Pair> change = new LinkedList<>();

    public void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;

        for(int i = 0 ; i< row; i++)
        {
            for(int j = 0 ; j< col;j ++) {
                int cur_state = board[i][j];
                int num_of_one = 0;
                int num_of_zero = 0;
                for (int z = 0; z < 8; z++) {
                    int x = i + dir[z][0];
                    int y = j + dir[z][1];
                    if (x >= 0 && x < row && y >= 0 && y < col) {
                        if (board[x][y] == 1)
                            num_of_one++;
                        else
                            num_of_zero++;
                    }
                }

                if (cur_state == 0) {
                    if (num_of_one == 3)
                        change.add(new Pair(i, j));
                } else if (cur_state == 1)
                {
                    if(num_of_one < 2)
                        change.add(new Pair(i,j));
                    else if(num_of_one > 3)
                        change.add(new Pair(i,j));
                }
            }
        }

        for(int i =0;i<change.size();i++)
        {
            int x = change.get(i).i;
            int y = change.get(i).j;

            board[x][y] = 1 - board[x][y];
        }
    }
}
