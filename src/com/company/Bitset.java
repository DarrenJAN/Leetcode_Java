package com.company;

public class Bitset {
    int[] bitset ;
    int size;
    int nums_one;
    int num;
    public Bitset(int size) {
        bitset = new int[size];
        this.size = size;
        nums_one = 0;
    }

    public void fix(int idx) {
        if( idx >= size || idx <0)
            return;

        if(bitset[idx] == 0)
        {
            bitset[idx] = 1;
            nums_one ++;
        }

        num = num & ( 1 << idx);

    }

    public void unfix(int idx) {
        if( idx >= size || idx <0)
            return;

        if(bitset[idx] == 1)
        {
            bitset[idx]  = 0;
            nums_one--;

        }

    }

    public void flip() {
        for(int i = 0 ;i< size;i++)
        {
            bitset[i] = 1 - bitset[i];
        }
        nums_one = size - nums_one;
    }

    public boolean all() {
         return nums_one == size;
    }

    public boolean one() {
        return nums_one > 0;
    }

    public int count() {
        return nums_one;
    }

    public String toString() {
        String result = "";
        for(int i = 0 ;i<size;i++)
            result += bitset[i];

        return result;
    }
}
