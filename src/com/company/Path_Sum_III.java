package com.company;

public class Path_Sum_III {
    int result = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null)
            return result;
        backtrack(root, 0 , targetSum);
        if(root.left != null)
            pathSum(root.left, targetSum);
        if(root.right != null)
            pathSum(root.right, targetSum);
        return result;

    }

    public void backtrack(TreeNode root, int cur_sum, int targetSum)
    {
        if(root == null)
            return;

        cur_sum += root.val;
        if(cur_sum == targetSum)
            result++;

        backtrack(root.left, cur_sum, targetSum);
        backtrack(root.right, cur_sum, targetSum);
    }
}
