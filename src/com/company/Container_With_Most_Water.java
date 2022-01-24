package com.company;

public class Container_With_Most_Water {
    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int maxarear = Math.min(height[left] , height[right]) * (right - left);

        while(left < right )
        {
            if(height[left] < height[right])
            {
                left++;
            }else
                right --;

            maxarear = Math.max(maxarear, Math.min(height[left] , height[right]) * (right - left));
        }

        return maxarear;
    }
}
