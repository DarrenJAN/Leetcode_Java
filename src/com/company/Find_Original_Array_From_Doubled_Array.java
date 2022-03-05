package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Find_Original_Array_From_Doubled_Array {
    public int[] findOriginalArray(int[] changed) {
        int length = changed.length;
        if(length % 2 != 0)
            return new int[0];

        int[] result = new int[length/2];
        int k =0;
        HashMap<Integer, Integer> hashMap =new HashMap<>();
        int count = 0;

        for(int i = 0;i< length;i++) {
            if (!hashMap.containsKey(changed[i])) {
                hashMap.put(2 * changed[i], hashMap.getOrDefault(2 * changed[i], 0)+1);
            } else {
                count++;

                if(hashMap.get(changed[i]) == 1)
                    hashMap.remove(changed[i]);
                else
                {
                    hashMap.put(changed[i], hashMap.get(changed[i])-1);
                }

                result[k++] = changed[i]/2;

            }

            if (count == length / 2)
                break;

        }

        return result;
    }
}
