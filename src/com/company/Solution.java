package com.company;

import java.util.Random;

public class Solution {
    int[] original;
    int[] shuffle;
    Random rand = new Random();

    public Solution(int[] nums) {
        original = new int[nums.length];
        for(int i = 0;i< nums.length;i++)
        {
            original[i] = nums[i];
            shuffle = original.clone();
        }

    }

    public int[] reset() {
         shuffle = original;
         original = original.clone();
         return shuffle;
    }

    public int[] shuffle() {
        for(int i = 0;i < shuffle.length;i++)
        {
            int num = rand.nextInt(shuffle.length - i ) + i ;
            int tmp = shuffle[i];
            shuffle[i] = shuffle[num];
            shuffle[num]  =tmp;
        }
        return shuffle;
    }
}
