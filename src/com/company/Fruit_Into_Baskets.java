package com.company;

import java.util.HashMap;
import java.util.HashSet;

public class Fruit_Into_Baskets {
    public int totalFruit(int[] fruits) {
        int length = fruits.length;
        int slide_window = length;

        while(slide_window >0)
        {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for(int i = 0;i<slide_window;i++)
            {
                hashMap.put(fruits[i], hashMap.getOrDefault(fruits[i], 0) +1);
            }
            if(hashMap.size() <= 2)
                return slide_window;

            for(int i =1;i+slide_window <=length ;i ++ )
            {
                if(hashMap.get(fruits[i-1]) == 1)
                {
                    hashMap.remove(fruits[i-1]);
                }else
                {
                    hashMap.put(fruits[i-1], hashMap.get(fruits[i-1]) -1);
                }

                hashMap.put(fruits[i+slide_window-1], hashMap.getOrDefault(fruits[i+slide_window-1], 0)+1);

                if(hashMap.size() <= 2)
                    return slide_window;
            }


            slide_window--;
        }

        return slide_window;
    }


    public int totalFruit_2(int[] fruits) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int left = 0;
        int right= 0;
        int length =fruits.length;
        int result = 0;

        while(right < length)
        {
            int cur = fruits[right];
            hashMap.put(cur, hashMap.getOrDefault(cur, 0)+1);
            while (hashMap.size() > 2 )
            {
                hashMap.put(fruits[left], hashMap.get(fruits[left])-1);
                if(hashMap.get(fruits[left]) == 0)
                    hashMap.remove(fruits[left]);
                left++;
            }

            result = Math.max(result, right - left+1);
            right ++;
        }
        return result;
    }
}
