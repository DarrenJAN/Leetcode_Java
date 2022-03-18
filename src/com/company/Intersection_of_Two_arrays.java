package com.company;

import java.util.*;

public class Intersection_of_Two_arrays {
    public int[] intersection_2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int l = 0;
        int r = 0;
        List<Integer> result = new ArrayList<>();

        while(l < nums1.length && r < nums2.length)
        {
            if(nums1[l] == nums2[r])
            {

                if(result.size() != 0 && result.get(result.size()-1) == nums1[l])
                {
                    l++;
                    r++;
                    continue;
                }else
                {
                    result.add(nums1[l]);
                    l++;
                    r++;
                }

            }else if(nums1[l] <  nums2[r])
            {
                l++;
            }else
            {
                r++;
            }
        }
        int[] res = new int[result.size()];
        for(int i  = 0;i< result.size();i++)
        {
            res[i] = result.get(i);
        }
        return res;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        int n = nums1.length;
        int m = nums2.length;

        for(int i = 0;i<n; i++)
        {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) +1);
        }

        for(int i =0;i<m;i++)
        {
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) != 0)
            {
                result.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) -1);
            }
        }

        int[] res = new int[result.size()];

        for(int i = 0;i<result.size();i++)
        {
            res[i] = result.get(i);
        }
        return res;


    }
}
