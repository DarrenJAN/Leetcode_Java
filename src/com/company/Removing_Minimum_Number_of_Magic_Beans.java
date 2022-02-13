package com.company;

import java.util.Arrays;

public class Removing_Minimum_Number_of_Magic_Beans {

    public long minimumRemoval(int[] beans) {
        int n = beans.length;
        int result = Integer.MAX_VALUE;

        for(int i =0;i<n;i++)
        {
            int sum = 0;
            for(int j = 0;j<n;j++)
            {
                if(i != j)
                {
                    if(beans[j] > beans[i])
                    {
                        sum+= (beans[i] - beans[j]);
                    } else
                    {
                        sum+= beans[j];
                    }
                }
            }

            result = Math.min(result, sum);
        }

        return result;

    }

    public long minimumRemoval_2(int[] beans) {
        Arrays.sort(beans);
        long  result = Long.MAX_VALUE;

        long n = beans.length;
        long sum = 0;

        for(int i = 0;i<n;i++)
        {
            sum+= beans[i];
        }

        for(int i =0;i<n;i++)
        {
            if(i != 0 && beans[i-1] == beans[i])
                continue;
            long cur_sum = sum - beans[i] * (n - i);
            result = Math.min(cur_sum, result);
        }

        return result;
    }
}
