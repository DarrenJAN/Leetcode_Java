package com.company;

public class Balanced_Binary_Tree {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;

        TreeNode left = root.left;
        TreeNode right = root.right;

        int left_height = depth(left);
        int right_height = depth(right);
        if(Math.abs(left_height - right_height) > 1)
            return false;
        else
            return isBalanced(root.left) && isBalanced(root.right);
    }

    public int depth(TreeNode root)
    {
        if (root == null)
            return 0;
        else
            return 1 + Math.max(depth(root.left), depth(root.right));
    }
}
