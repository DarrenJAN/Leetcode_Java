package com.company;

public class Number_of_Provinces {
    int col;
    int row;
    public int findCircleNum(int[][] isConnected) {
        int result = 0;
        this.row= isConnected.length;
        this.col = isConnected[0].length;

        for(int i = 0;i<row;i++)
        {
            for(int j = 0;j< col; j++)
            {
                if(isConnected[i][j] == 1)
                {
                    result++;
                    dfs(isConnected, i, j);
                }
            }
        }
        return result;
    }

    public void dfs(int[][] isConnected, int x, int y)
    {
        if(isConnected[x][y] == 0)
            return;

        if(isConnected[x][y] == 1)
        {
            isConnected[x][y] = 0;
            for(int i = 0; i< col;i++)
            {
                if(isConnected[x][i] == 1)
                {
                    isConnected[x][i] = 0;
                    dfs(isConnected, i,x);
                }
            }
        }
    }
}
