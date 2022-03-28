package com.company;

public class Selection_Sort {
    //O(N^2)
    //O(N) or O(1)
    public static void Selection_Sort(int[] nums)
    {
        for(int i = 0;i < nums.length;i++)
        {
            int cur_min= i;
            for(int j  = i; j< nums.length;j++)
            {
                if(nums[j] < nums[cur_min] )
                {
                    cur_min = j;
                }
            }
            swap(nums, i, cur_min);
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
        Selection_Sort(ar);
        printArray(ar);
    }

}
