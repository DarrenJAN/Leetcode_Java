package com.company;

import java.util.HashSet;

public class Happy_Number {
    public boolean isHappy(int n) {
        HashSet<Integer> hashSet = new HashSet<>();
        while(n  != 1)
        {
            if(hashSet.contains(n))
                return false;
            else
            {
                hashSet.add(n);
                int new_n = 0;
                while(n != 0)
                {
                    new_n += (n % 10) * (n%10);
                    n = n/10;
                }

                n = new_n;
                //System.out.println(new_n);
                if(n == 1)
                    break;

            }
        }
        return true;
    }
}
