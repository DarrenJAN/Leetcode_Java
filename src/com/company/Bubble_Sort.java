package com.company;

public class Bubble_Sort {
    public static void Bubble_Sort(int[] nums)
    {
        int i = 0;
        while(i < nums.length-1)
        {
            if(nums[i]  > nums[i+1])
            {
                swap(nums, i, i+1);
                i = 0;
            }else
                i++;

        }
    }

    public static void swap(int[] nums, int i, int j)
    {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    static void  printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int ar [] = {64, 34, 25, 12, 22, 11, 90};
        Bubble_Sort(ar);
        printArray(ar);
    }
}
