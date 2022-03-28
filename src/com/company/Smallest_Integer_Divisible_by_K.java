package com.company;

import java.util.HashSet;

public class Smallest_Integer_Divisible_by_K {
    public int smallestRepunitDivByK(int k) {
        HashSet<Integer> reminder = new HashSet<>();
        int result = 1;
        while (result % k != 0)
        {

            int mode = result % k;
            if(reminder.contains(mode))
                return -1;
            else
            {
                reminder.add(mode);
            }

            result = result * 10 + 1;

        }
        return result;

    }
}
