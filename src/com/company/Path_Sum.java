package com.company;

public class Path_Sum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)
            return false;
        return has_helper(root, 0, targetSum);
    }

    public boolean has_helper(TreeNode root, int cur, int target)
    {
        if(root == null)
            return false;

        if(root.left == null && root.right == null)
        {
            return (cur+ root.val) == target;
        }

        return has_helper(root.left, cur+root.val, target) || has_helper(root.right, cur + root.val, target);
    }
}
