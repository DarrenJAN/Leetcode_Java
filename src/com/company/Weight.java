package com.company;

import java.util.Random;

public class Weight {
    int[] weight;
    int[] prewight;
    int sum =0 ;
    Random rand = new Random();
    public Weight(int[] w) {
        weight = w;
        prewight = new int[w.length];
        sum = 0;

        for(int i =0;i< weight.length;i++)
        {
            sum += weight[i];
            prewight[i] = sum;
        }
    }

    public int pickIndex() {
        double wight = sum * Math.random();
        for(int i = 0 ;i<prewight.length;i++)
        {
            if(wight < prewight[i])
            {
                return i;
            }
        }
        return -1;

    }
}
