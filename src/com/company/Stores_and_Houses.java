package com.company;

import java.util.Arrays;

public class Stores_and_Houses {
   static public int[] storesAndHouses(int[] stores, int[] house)
    {
        Arrays.sort(stores);
        int[] result = new int[house.length];
        for(int i = 0;i< house.length;i++)
        {
            int cur_min = Integer.MAX_VALUE;
            int cur_reuslt = 0;

            int l = 0;
            int r = stores.length-1;
            while(l <= r)
            {
                int mid = (r - l)/2  + l;
                if(Math.abs(stores[mid] - house[i]) < cur_min)
                {
                    cur_min = Math.abs(stores[mid] - house[i]);
                    cur_reuslt = stores[mid];
                }
                if(stores[mid] == house[i])
                {
                    break;
                }else if(stores[mid] < house[i])
                {
                    l = mid +1;
                }else
                    r = mid -1;
            }
            result[i] = cur_reuslt;
        }
        return  result;
    }

    public static void main(String[] args) {
        int[] result = storesAndHouses(new int[]{4, 8, 1, 1}, new int[]{5, 3, 1, 2, 10});
        for(int i = 0;i< result.length;i++)
        {
            System.out.println(result[i]);
        }
    }
    //house = [5,10, 17]
    // stores = [1,5, 11,20]
}
