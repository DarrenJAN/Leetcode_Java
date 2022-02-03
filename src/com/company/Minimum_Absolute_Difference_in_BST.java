package com.company;

public class Minimum_Absolute_Difference_in_BST {
    int result = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        dfs(root, null, null);
        return result;
    }

    public void dfs(TreeNode root, Integer min, Integer max)
    {
        if(root == null )
            return;

        if( min != null )
        {
            result = Math.min(result,  Math.abs(root.val - min));


        }

        if(max != null)
        {
            result = Math.min(result, Math.abs(root.val - max));

        }
        dfs(root.left, min, root.val);
        dfs(root.right, root.val, max);
    }
}
