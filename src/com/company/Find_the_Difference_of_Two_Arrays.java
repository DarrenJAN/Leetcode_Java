package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Find_the_Difference_of_Two_Arrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> innum1 = new ArrayList<>();
        List<Integer> innum2 = new ArrayList<>();

        HashSet<Integer> hashSet1 = new HashSet<>();
        HashSet<Integer> hashSet2 = new HashSet<>();

        for(Integer i : nums1)
        {
            hashSet1.add(i);
        }

        for(Integer i : nums2)
        {
            hashSet2.add(i);
        }

        for(Integer i : hashSet2)
        {
            if(!hashSet1.contains(i))
            {
                innum2.add(i);
            }
        }

        for(Integer i : hashSet1)
        {
            if(!hashSet2.contains(i))
            {
                innum1.add(i);
            }
        }
        result.add(innum1);
        result.add(innum2);
        return result;
    }

}
