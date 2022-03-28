package com.company;

import java.util.Queue;

public class Quick_Sort {
    public static void Quick_Sort(int[] nums)
    {
        Quick_Sort_helper(nums, 0, nums.length-1);
    }

    public static void Quick_Sort_helper(int[] nums, int l, int r) {
        if (l < r)
        {
            int index = partition(nums, l, r);
            Quick_Sort_helper(nums, l, index-1);
            Quick_Sort_helper(nums, index +1 , r);
        }
    }

    public static int partition(int[] nums, int l , int r)
    {
        int pivot = nums[r];
        int j = -1;
        for(int i = 0 ; i<= r -1; i++)
        {
            if(nums[i] < pivot)
            {
                j++;
                swap(nums, j , i);
            }
        }
        swap(nums, j+1, r);
        return j+1;
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
        Quick_Sort(ar);
        printArray(ar);
    }

}
