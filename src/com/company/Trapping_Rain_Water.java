package com.company;

import java.util.ArrayList;
import java.util.List;

public class Trapping_Rain_Water {
    public int trap(int[] height) {

        int n = height.length;
        int[] left_max = new int[n];
        int[] right_max = new int[n];
        int left_tmp = Integer.MIN_VALUE;
        int right_tmp = Integer.MIN_VALUE;
        for(int i = 0;i<height.length;i++)
        {
            if(i == 0)
                left_max[i] = height[i];
            else
            {
                int tmp = Math.max(left_max[i-1], height[i]);
                left_max[i] = tmp;
            }
        }

        for(int i = height.length-1;i>=0;i--)
        {
            if(i == height.length-1)
                right_max[i] = height[i];
            else
            {
                int tmp = Math.max(right_max[i-1], height[i]);
                right_max[i] = tmp  ;
            }
        }

        int ans = 0;
        for(int i= 0;i<n;i++)
        {
            int tmp =  Math.min(left_max[i], right_max[i]) - height[i];
            ans += tmp;
        }
        return ans;
    }
}
