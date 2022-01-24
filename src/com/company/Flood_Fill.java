package com.company;

public class Flood_Fill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];

        if( color != newColor)
            dfs(image, sr, sc, newColor, color);

        return  image;

    }

    void  dfs(int[][] image, int r, int c, int  newColor, int color)
    {
        if(r<0 || r >= image.length || c < 0 || c>= image[0].length)
            return;

        if(image[r][c] == color )
        {
            image[r][c]  = newColor;
            dfs(image, r+1, c , newColor,color);
            dfs(image,r-1,c,newColor,color);
            dfs(image, r, c+1, newColor,color);
            dfs(image, r, c-1, newColor, color);
        }

    }
}
