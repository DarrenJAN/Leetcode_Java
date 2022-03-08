package com.company;

import java.util.HashSet;

public class Valid_Square {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        HashSet<Double> hashSet = new HashSet<>();
        if(equal(p1, p2) || equal(p1, p3) || equal(p1, p4) || equal(p2, p3) ||equal(p2, p4) || equal(p3, p4))
            return false;
        hashSet.add(distance(p1, p2));
        hashSet.add(distance(p1, p3));
        hashSet.add(distance(p1, p4));
        hashSet.add(distance(p2, p3));
        hashSet.add(distance(p2, p4));
        hashSet.add(distance(p3, p4));
        return hashSet.size()== 2;
    }

    Double distance(int[] p1, int[] p2)
    {
        return (double) (p1[0] - p2[0]) * (p1[0] - p2[0]) +  (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }

    boolean equal(int[] p1, int[]p2)
    {
        return p1[0] == p2[0] && p1[1] == p2[1];
    }
}
