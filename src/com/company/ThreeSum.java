package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        int n = nums.length;
        if(n < 3)
            return result;

        for(int i = 0; i < n-2; i++)
        {
            if(i != 0 && nums[i-1] == nums[i])
                continue;
            int left = i+1;
            int right = n-1;
            while(left < right)
            {
                if(nums[i]+ nums[left] + nums[right] == 0 )
                {
                    List<Integer> tmp =new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    result.add(tmp);

                    while(left < right && nums[left] == nums[left+1]) left++;
                    while(left < right && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                }else if(nums[i]+ nums[left] + nums[right]  < 0 )
                {
                    left++;
                }else
                    right --;
            }
        }
        return result;

    }

}
