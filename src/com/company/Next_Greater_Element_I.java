package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Next_Greater_Element_I {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Stack<Integer> stack  = new Stack<>();

        for(int i = 0 ;i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek())
            {
                int last = stack.pop();
                hashMap.put(last, nums2[i]);
            }
            stack.add(nums2[i]);
        }

        for(int i = 0; i < nums1.length; i++)
        {
            if(hashMap.containsKey(nums1[i]))
            {
                result[i] = hashMap.get(nums1[i]);
            }else
            {
                result[i] = -1;
            }
        }
        return result;
    }

}
