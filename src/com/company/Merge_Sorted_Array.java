package com.company;

public class Merge_Sorted_Array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0 )
            return;

        if(m  == 0)
        {
            for(int i = 0; i<n ;i++)
            {
                nums1[i] = nums2[i];
            }
            return;
        }

        int left = 0;
        int right = 0;
        int[] tmp = new int[m+n];
        int i =0;
        while(left < m  || right < n)
        {

            if(left < m && right < n)
            {
                if(nums1[left] < nums2[right])
                {
                    tmp[i] = nums1[left];
                    left++;
                }else
                {
                    tmp[i] = nums2[right];
                    right ++;
                }
            }
            else if(left == m)
            {
                tmp[i] = nums2[right];
                right ++;
            } else
            {
                tmp[i] = nums1[left];
                left++;
            }

            i++;
        }

        for(int j= 0;j<m+n;j++)
        {
            nums1[j] = tmp[j];
        }


    }

}
