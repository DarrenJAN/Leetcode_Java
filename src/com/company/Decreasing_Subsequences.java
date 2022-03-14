package com.company;

import java.util.ArrayList;
import java.util.List;

public class Decreasing_Subsequences {
    static public int decreasingSubseq(int... S){
        List<Integer> list = new ArrayList<>();

        if(S.length == 0)
        {
            return 0;
        }

        list.add(S[0]);
        for(int i = 1;i< S.length;i++)
        {
             int ind = index(list, S[i]);
             if(ind == list.size())
                 list.add(S[i]);
             else
                 list.set(ind, S[i]);
             System.out.println(ind);
        }

        return list.size();
    }

    static public int index(List<Integer> list, int num )
    {
        int length = list.size();
        int l = 0;
        int r = length-1;

        while(l <= r)
        {
            int mid = (r - l)/2 + l;
            if(list.get(mid) <= num)
                l = mid +1;
            else
                r = mid-1;
        }

        return l;
    }

    public static void main(String[] args) {
        test(decreasingSubseq(2, 9, 12, 13, 4, 7, 6, 5, 10), 4);
        test(decreasingSubseq(5, 2, 4, 3, 1, 6), 3);
        test(decreasingSubseq(1, 1, 1), 3);
    }

    private static void test(int actual, int expected) {
        if (actual == expected) {
            System.out.println("PASSED!");
        } else {
            System.out.println(String.format("FAILED! Expected %d, but got %d", expected, actual));
        }
    }
}
