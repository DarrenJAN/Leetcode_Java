package com.company;

public class Min_Days_to_Bloom {
    public static int minDaysBloom(int[] roses, int k, int n) {
        if(n * k > roses.length)
            return -1;
        int cur_min = roses[0];
        int cur_max = roses[0];
        for(int i =1;i<roses.length;i++)
        {
            cur_max = Math.max(cur_max , roses[i]);
            cur_min = Math.min(cur_min, roses[i]);
        }

        int left = cur_min;
        int right =cur_max;
        while(left <= right)
        {
            int mid = (right - left) /2 + left;
            if(isValid(mid, roses, k,n))
                right = mid-1;
            else
                left = mid +1;
        }
        return left;


    }

    public static boolean isValid(int day,int[] rose, int k, int n)
    {
        int cur_size = 0;
        int cur_n = 0;

        for(int i =0;i<rose.length;i++)
        {
            if(rose[i] <= day )
            {
                cur_size ++;
                if(cur_size == k) {
                    cur_n++;
                    cur_size = 0;
                }
            }else
            {
                cur_size= 0;
            }
            if(cur_n == n)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a ={1, 2, 4, 9, 3, 4, 1};
        System.out.println(minDaysBloom(a, 2,3));
    }
}
