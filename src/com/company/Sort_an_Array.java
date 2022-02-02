package com.company;

public class Sort_an_Array {
    public int[] sortArray(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        if(r <= 0)
            return nums;


        merge_sort(nums, l, r);
        return nums;


    }

    public void merge_sort(int[] nums, int l, int r)
    {
        if(l >= r)
            return;

        int mid = (r - l) /2 + l;
        merge_sort(nums, l, mid);
        merge_sort(nums, mid+1 , r);
        merge(nums, l, mid, r);
    }

    public void merge(int[] nums, int l, int mid, int r)
    {
        int len = r - l +1;
        int[] temp = new int[len];

        int i = 0;
        int ll = l;
        int rr = mid+1;
        while(ll<= mid && rr <= r)
        {
            if(nums[ll] < nums[rr])
            {
                temp[i] = nums[ll];
                ll++;
            }else
            {
                temp[i] = nums[rr];
                rr++;
            }
            i++;
        }

        while(ll <= mid )
        {
            temp[i] = nums[ll];
            ll++;
            i++;
        }
        while(rr <= r )
        {
            temp[i] = nums[rr];
            rr++;
            i++;
        }

        for(i = l; i<=r;i++)
            nums[l] = temp[i-l];

    }

    ////上面没对 == = = 下面是对的
    private int[] merge_2(int[] a,int low, int mid, int high) {
        int i=low;
        int k=0;
        int j=mid+1;
        int[] temp = new int[high-low+1];

        while((i<=mid) && (j<=high)) {
            if(a[i] < a[j]) {
                temp[k++] = a[i++];
            }
            else temp[k++] = a[j++];
        }

        while(i<=mid) temp[k++] = a[i++];

        while(j<=high) temp[k++] = a[j++];

        for(int l=low;l<=high; l++) {
            a[l] = temp[l-low];
        }
        return a;
    }

    private void mergesort(int[] a, int low, int high) {

        if(low<high) {
            int mid = (high+low)/2;
            mergesort(a,low,mid);
            mergesort(a,mid+1,high);
            merge_2(a,low,mid,high);
        }
    }

}
