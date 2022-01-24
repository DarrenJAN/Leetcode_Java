package com.company;

public class Rotate_Array {
    //this is not acceptable
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n == k || n == 1)
            return;
        for (int i = 0; i < k; i++) {
            rotate_helper(nums);
        }
    }

    public void rotate_helper(int[] nums) {
        int n = nums.length;
        int last = nums[n - 1];
        for (int i = n - 1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }
        nums[0] = last;
    }

    //rewrite
    public void rotate_2(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if (n == k || n == 1)
            return;

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[(i + k) % n] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = a[i];
        }
    }


    // reverse !!!! 直接封神
    public void rotate_3(int[] nums, int k)
    {
        int n = nums.length-1;
        k = k % (n+1);
        reverse_helper(nums,0, n);
        reverse_helper(nums,0, k-1);
        reverse_helper(nums,k,n);

    }

    public void reverse_helper(int[] nums, int start, int end)
    {
        while(start < end)
        {
            int tmp = nums[end];
            nums[end] = nums[start];
            nums[start] = tmp;

            start ++;
            end--;
        }
    }
}
