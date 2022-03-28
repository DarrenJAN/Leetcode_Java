package com.company;

import java.util.Arrays;

public class H_Index {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int i = 0;
        int n = citations.length;
        while(i < citations.length && citations[n - i -1] > i)
        {
            i++;
        }
        return i;
    }
}
