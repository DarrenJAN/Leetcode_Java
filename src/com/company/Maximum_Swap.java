package com.company;

public class Maximum_Swap {
    public int maximumSwap(int num) {
        char[] chars = Integer.toString(num).toCharArray();
        int[] nums = new int[chars.length];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = chars[i] - '0';
        }

        int large_index = 0;
        int small_index = 0;
        for (int i = 0; i < nums.length-1; i++) {
            small_index = i;
            large_index = i;
            for (int j = i + 1; j < nums.length; j++) {
                if( nums[j] > nums[i] && nums[j] >= nums[large_index]) {
                    large_index = j;
                }
            }
            if (large_index != i)
            {
                int tmp = nums[small_index];
                nums[small_index] = nums[large_index];
                nums[large_index] = tmp;
                break;
            }

        }


        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < nums.length; i++)
        {
            stringBuilder.append(nums[i]);
        }

        int result =  Integer.parseInt(stringBuilder.toString());
        return  result;

    }

}
