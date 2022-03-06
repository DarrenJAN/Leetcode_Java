package com.company;

import java.util.HashMap;

public class Count_Good_Meals {
    public int countPairs(int[] deliciousness) {
        int mod = (int)Math.pow(10, 9) + 7;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int count = 0;
        for(int i = 0;i<deliciousness.length;i++)
        {
            int cur = deliciousness[i];

            int sum = 1;
            for(int j =0;j< 22;j++)
            {
                if(hashMap.containsKey(sum - cur))
                {
                    count += hashMap.get(sum - cur);
                    count = count % mod;
                }
                sum *= 2;
            }
            hashMap.put(cur, hashMap.getOrDefault(cur, 0)+1);
        }
        return count;
    }
}
