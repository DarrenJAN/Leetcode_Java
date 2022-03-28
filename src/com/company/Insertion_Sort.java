package com.company;

public class Insertion_Sort {
    public static void Insertion_Sort(int[] nums)
    {
        for(int i = 1; i < nums.length;i++)
        {
            int tmp = nums[i];
            int j = i;
            while(j > 0 && nums[j-1] > tmp )
            {
                nums[j] = nums[j-1];
                j--;
            }
            if(i != j)
                nums[j] = tmp;
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
        Insertion_Sort(ar);
        printArray(ar);
    }
}
