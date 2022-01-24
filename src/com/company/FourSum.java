package com.company;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);

        for(int i = 0; i< nums.length-3; i++)
        {
            if(i != 0 && nums[i-1] == nums[i])
                continue;
            for(int j = i+1; j< nums.length; j++)
            {
                if(j >i+1 && nums[j-1] == nums[j])
                    continue;
                int k = j+1;
                int z = nums.length-1;

                while( k< z)
                {
                    int sum = nums[i] + nums[j] + nums[k] + nums[z];
                    if(sum  == target)
                    {
                        List<Integer> cur = new LinkedList<>();
                        cur.add(nums[i]);
                        cur.add(nums[j]);
                        cur.add(nums[k]);
                        cur.add(nums[z]);
                        result.add(cur);
                        while(k < z && nums[k] == nums[k+1]) k++;
                        while(k < z && nums[z] == nums[z-1]) z--;
                        k++;
                        z--;


                    }else if(sum < target)
                        k++;
                    else
                        z--;
                }
            }
        }

        return result;
    }
}
