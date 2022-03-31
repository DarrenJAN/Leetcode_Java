package com.company;

public class Range_Addition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];
        for(int i = 0;i < updates.length;i++)
        {
            int start = updates[i][0];
            int end = updates[i][1];
            int value = updates[i][2];
            for(int j = start;j< end;j++)
            {
                result[j] += value;
            }
        }
        return result;
    }

    public int[] getModifiedArray_prefix(int length, int[][] updates) {
        int[] result = new int[length];
        for(int i = 0;i < updates.length;i++) {
            int start = updates[i][0];
            int end = updates[i][1];
            int value = updates[i][2];

            result[start] += value;
            if(end < result.length-1)
            {
                result[end +1] -=value;
            }
        }

        for(int i = 1;i< result.length;i++)
        {
            result[i] += result[i-1];
        }
        return result;
    }
}
