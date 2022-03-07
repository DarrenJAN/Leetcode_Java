package com.company;

import java.util.*;

public class Array_of_Doubled_Pairs {
    public boolean canReorderDoubled(int[] arr) {
        int length = arr.length;
        Integer[] a = new Integer[length];
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i =0;i<  length;i++)
        {
            a[i] = arr[i];
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) +1);
        }

        Arrays.sort(a, Comparator.comparingInt(Math::abs));
        for(int i =0 ;i< length;i++)
        {
            int cur_num = a[i];
            int double_num = 2*cur_num;

            if(hashMap.get(cur_num) <= 0)
                continue;

            if(!hashMap.containsKey(double_num) || hashMap.get(double_num) <= 0)
                return false;

            hashMap.put(cur_num, hashMap.get(cur_num)-1);
            hashMap.put(double_num, hashMap.get(double_num)-1);
        }

        return true;
    }
}
