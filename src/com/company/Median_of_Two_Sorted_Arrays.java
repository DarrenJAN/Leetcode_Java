package com.company;

public class Median_of_Two_Sorted_Arrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int [] nums = new int[n1+n2];
        int l1 = 0;
        int l2 = 0;
        int l = 0;
        while(l1 < n1 && l2 < n2)
        {
            if(nums1[l1] < nums2[l2])
            {
                nums[l++] = nums1[l1++];
            }else
            {
                nums[l++] = nums2[l2++];
            }
        }

        while(l1 < n1)
        {
            nums[l++] = nums1[l1++];
        }
        while(l2 < n2)
        {
            nums[l++] = nums2[l2++];
        }


        int mid = (n1 + n2) /2;

        if((n1 + n2 ) % 2 == 0)
        {

            return (nums[mid] + nums[mid-1]) / 2.0;
        }else
            return nums[mid] * 1.0;
    }
}
