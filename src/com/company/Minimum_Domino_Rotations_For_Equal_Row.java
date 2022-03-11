package com.company;

public class Minimum_Domino_Rotations_For_Equal_Row {
    public int minDominoRotations(int[] tops, int[] bottoms) {

        int top = check(tops[0], tops, bottoms);

        if(top != -1 || tops[0] == bottoms[0])
            return top;
        else
        {
            return  check(bottoms[0], tops, bottoms);
        }
    }

    public int check(int x, int[]tops, int[] bottoms)
    {
        int rotate_a = 0;
        int rotate_b = 0;

        for(int i =0;i<tops.length;i++)
        {
            if(tops[i] != x && bottoms[i] != x)
                return -1;
            else if(tops[i] == x && bottoms[i] == x)
                continue;
            else if(tops[i] == x)
            {
                rotate_b ++;
            }else if (bottoms[i] == x)
            {
                rotate_a ++;
            }
        }
        return Math.min(rotate_a, rotate_b);
    }
}
