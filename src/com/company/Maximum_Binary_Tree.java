package com.company;

public class Maximum_Binary_Tree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    public TreeNode helper(int[] nums, int start, int end)
    {
        if(start > end)
            return null;
        int index = max(nums, start, end);
        TreeNode root = new TreeNode(nums[index]);
        root.left = helper(nums, start, index -1);
        root.right = helper(nums, index+1, end);

        return root;
    }

    public int max(int[] nums, int start, int end)
    {
        int num = nums[start];
        int index = start;
        for(int i = start;i<= end;i++)
        {
            if(nums[i] > num)
            {
                num = nums[i];
                index = i;
            }
        }
        return index;
    }

}
