package com.company;

import java.util.ArrayList;
import java.util.List;

public class Find_Palindrome_With_Fixed_Length {
    public long[] kthPalindrome(int[] queries, int intLength) {
        List<List<String>> dp = new ArrayList<>();
        dp.add(new ArrayList<>());
        dp.add(new ArrayList<>());
        for(int i = 0;i<=9;i++)
        {
            dp.get(0).add(i+"");
            dp.get(1).add(i+""+i);
        }

        long[] result = new long[queries.length];
        if(intLength <= 2 )
        {
            for(int i = 0;i< queries.length;i++)
            {
                result[i] = Integer.valueOf(dp.get(intLength-1).get(queries[i]));
            }
            return result;
        }

        for(int i =3; i<= intLength;i++) {
            dp.add(new ArrayList<>());
            List<String> cur_strings = dp.get(i - 1);
            List<String> last_strings = dp.get(i-1-2);
            for (int j = 1; j <= 9; j++)
            {
                for(String s : last_strings)
                {
                    String cur = j + s+ j;
                    cur_strings.add(cur);
                }
            }
        }

        for(int i = 0;i< queries.length;i++)
        {
            result[i] = Integer.valueOf(dp.get(intLength-1).get(queries[i]));
        }
        return result;

    }
}
