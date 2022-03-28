package com.company;

public class Merge_Sort {
    public static void Merge_Sort(int[] nums)
    {
        Merge_helper(nums, 0, nums.length-1);
    }

    public static  void Merge_helper(int [] nums, int l, int r)
    {
        if(l < r )
        {
            int mid = (r - l) /2 + l;
            Merge_helper(nums, l , mid);
            Merge_helper(nums, mid +1, r);
            Merge(nums, l, mid, r);
        }

    }

    public static void Merge(int[] nums, int l, int mid, int r)
    {
        int n1 = mid -l + 1;
        int n2 = r - mid;
        int[] l1 = new int[mid-l+1];
        int[] l2 = new int[r - mid];
        for(int i =0 ; i< n1;i++)
        {
            l1[i] = nums[i+l];
        }

        for(int i = 0; i<n2 ;i++)
        {
            l2[i] = nums[i + mid+1];
        }

        int first = 0;
        int second = 0;
        int k = l;
        while(first < n1  && second < n2)
        {
            if(l1[first] < l2[second])
            {
                nums[k++] = l1[first++];
            }else
            {
                nums[k++] = l2[second++];
            }
        }

        while(first < n1)
        {
            nums[k++] = l1[first++];
        }

        while(second < n2)
        {
            nums[k++] = l2[second++];
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
        Merge_Sort(ar);
        printArray(ar);
    }

}
