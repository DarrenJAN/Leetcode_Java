package com.company;

public class Missing_Element_in_Sorted_Array {
    public int missingElement(int[] nums, int k) {
        int start = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (start == nums[i]) {
                continue;
            } else {
                int diff = nums[i] - start - 1;
                if (diff >= k) {
                    return start + k;
                } else {
                    k -= diff;
                    start = nums[i] + 1;
                }

            }
        }

        if (k > 0)
            start += k;

        return start;
    }


}

