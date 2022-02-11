package com.company;

import javax.swing.text.Segment;
import java.util.concurrent.Semaphore;

public class NumArray {
    int[] nums;
    int[] sum ;
//    public NumArray(int[] nums) {
//        this.nums = nums;
//        sum = new int[nums.length];
//
//        int cur_sum = 0;
//        for(int i = 0;i<nums.length;i++)
//        {
//            cur_sum += nums[i];
//            sum[i] = cur_sum;
//        }
//    }
//
//    public int sumRange(int left, int right) {
//        if(left == 0)
//            return sum[right];
//        else
//            return sum[right] - sum[left-1];
//    }
//
//
//    public void update(int index, int val) {
//        nums[index] = val;
//
//        int cur_sum = index == 0 ? 0:sum[index-1];
//
//        for(int i = index;i<nums.length;i++)
//        {
//            sum[i] = cur_sum + nums[i];
//        }
//    }

    ////////////////////
    SegmentTreeNode root;
    public NumArray(int[] nums) {
        root = buildtree(nums, 0, nums.length-1);

    }

    public int sumRange(int left, int right) {
        return sumRangeroot(root, left, right);
    }


    public void update(int index, int val) {
        updateTreeNode(root, index, val);
    }


    public int sumRangeroot(SegmentTreeNode root, int left, int right) {


        if(root.start == left && root.end == right)
        {
            return root.sum;
        }


        int mid = (root.start + root.end) /2;
        if(right <= mid)
            return sumRangeroot(root.left, left, right);
        else if(left > mid)
            return sumRangeroot(root.right, left, right);
        else
            return sumRangeroot(root.left, left, mid) + sumRangeroot(root.right, mid +1, right);
    }


    public SegmentTreeNode buildtree(int nums[], int left, int right)
    {
        if(left == right)
            return new SegmentTreeNode(left, left, nums[left]);

        int mid = ( right - left ) /2 + left;
        SegmentTreeNode left_node =  buildtree(nums, left, mid);
        SegmentTreeNode right_node =  buildtree(nums, mid +1, right);
        SegmentTreeNode root = new SegmentTreeNode(left, right, left_node.sum + right_node.sum, left_node, right_node);
        return root;
    }

    public void updateTreeNode(SegmentTreeNode root, int index, int val)
    {
        if(root == null)
            return;

        if(index == root.start && index == root.end)
        {
            root.sum = val;
            return;
        }

        int mid = (root.start + root.end) /2;
        if(index <= mid )
            updateTreeNode(root.left, index, val);
        else
            updateTreeNode(root.right, index, val);

        root.sum = root.left.sum + root.right.sum;
    }



    class SegmentTreeNode{
        int start;
        int end;
        int sum;
        SegmentTreeNode left;
        SegmentTreeNode right;

        SegmentTreeNode(int start , int end, int sum)
        {
            this.start =start;
            this.end = end;
            this.sum = sum;
        }

        SegmentTreeNode(int start , int end, int sum, SegmentTreeNode left, SegmentTreeNode right)
        {
            this.start =start;
            this.end = end;
            this.sum = sum;
            this.left = left;
            this.right = right;
        }
    }
}
