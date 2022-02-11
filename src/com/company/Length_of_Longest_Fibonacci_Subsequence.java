package com.company;

import java.util.HashSet;

public class Length_of_Longest_Fibonacci_Subsequence {
    public int lenLongestFibSubseq(int[] arr) {
        HashSet<Integer> hashSet= new HashSet<>();
        int result = 0;
        for(int i = 0;i< arr.length;i++)
            hashSet.add(arr[i]);

        int len = arr.length;
        for(int i = 0; i< len ;i++)
        {
            for(int j = i+1; j< len;j++)
            {
                int A_1  = arr[i];
                int A_2 = arr[j];
                int A_3 = A_1 + A_2;
                int length = 2;
                while( hashSet.contains(A_3))
                {
                    length ++;
                    A_1 = A_2;
                    A_2 = A_3;
                    A_3 = A_1 + A_2;
                    result = Math.max(result, length);
                }
            }
        }

        return result;
    }
}
