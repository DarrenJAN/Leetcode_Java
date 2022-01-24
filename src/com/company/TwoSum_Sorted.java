package com.company;

public class TwoSum_Sorted {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        int[] index = new int[2];

        while(left < right)
        {
            if(numbers[left] + numbers[right] == target)
            {
                index[0] = left;
                index[1] = right;
                return index;
            }else if(numbers[left] + numbers[right] < target)
            {
                left ++;
            }else
                right --;
        }
        return index;
    }
}
