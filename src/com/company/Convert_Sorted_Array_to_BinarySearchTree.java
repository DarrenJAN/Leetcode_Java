package com.company;

public class Convert_Sorted_Array_to_BinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    public TreeNode helper(int[] nums, int l, int r)
    {
        if(l > r)
            return null;
        else
        {
            int mid = (r - l) /2 + l;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = helper(nums,l, mid-1);
            root.right = helper(nums, mid+1, r);
            return root;
        }
    }

}
