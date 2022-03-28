package com.company;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Sort_the_Matrix_Diagonally {
    public int[][] diagonalSort(int[][] mat) {
        HashMap<Integer, PriorityQueue<Integer>> hashMap = new HashMap<>();
        int row = mat.length;
        int col = mat[0].length;
        for (int i = 0; i < row; i++)
        {
            for(int j = 0; j < col;j++)
            {
                int id = i - j;
                if(!hashMap.containsKey(id))
                {
                    hashMap.put(id, new PriorityQueue<>());
                }
                hashMap.get(id).add(mat[i][j]);
            }
        }

        for (int i = 0; i < row; i++)
        {
            for(int j = 0; j < col;j++)
            {
                int id = i - j;
                mat[i][j] = hashMap.get(id).poll();
            }
        }
        return mat;
    }
}
